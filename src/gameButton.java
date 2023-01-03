import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameButton extends JButton {
    private int claim; //Se 0 não tem dono. Se 1 pertence ao player1. Se 2 pertence ao player2.
    private int position;
    private gameRules rules;

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

    public gameButton(int xy, gameRules rules) {
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
        this.position = xy;
        this.rules = rules;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    click();
                }
            }

            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
    }

    public void click(){
        rules.buttonClick(this);
    }
}
