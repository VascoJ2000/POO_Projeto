import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameButton extends JButton {
    private int claim; //Se 0 não tem dono. Se 1 pertence ao player1. Se 2 pertence ao player2.
    private int position;
    private int positionX;
    private int positionY;
    private gameRules rules; //Necessario para chamar o metodo que decide o que acontece quando se clica no buttão.

    public int getClaim() {
        return claim;
    }

    public void setClaim(int claim) {
        this.claim = claim;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public gameRules getRules() {
        return rules;
    }

    public void setRules(gameRules rules) {
        this.rules = rules;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public gameButton(int x, int y, int xy, gameRules rules) {
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        this.positionX = x;
        this.positionY = y;
        this.position = xy;
        this.rules = rules;
        this.claim = 0;
        //Clica do buttão só se o buttão esquerdo do rato for usado. Os metodos para a não ser mouseClicked não
        //têm nenhuma função associada mas addMouseListener não funciona sem eles.
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    click();
                }
            }

            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
    }
    //Chame gameRules para verificar se o buttão ainda não pertence a ninguém, se o jogador que o clicou marcou ponto
    //e se alguém ganhou.
    public void click(){
        rules.buttonClick(this);
    }
}
