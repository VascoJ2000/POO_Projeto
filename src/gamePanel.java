import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel {
    private gameBoard board; //O tabuleiro que deve estar no lado esquerdo e ocupar a maioria do painel.
    private JPanel infoPanel = new JPanel(); //O painel onde esta o texto que diz de quem é o turno.
    private JLabel info = new JLabel(); //Deve mudar o Texto para dizer de quem é o turno.
    private JButton endMatch = new JButton(); //Buttão que deve mudar para o ecrã inicial. "Cancel Match" - se o jogo ainda não acabou. "New game" se alguém ganhou.

    public gameBoard getBoard() {
        return board;
    }

    public void setBoard(gameBoard board) {
        this.board = board;
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public void setInfoPanel(JPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    public JLabel getInfo() {
        return info;
    }

    public void setInfo(JLabel info) {
        this.info = info;
    }

    public JButton getEndMatch() {
        return endMatch;
    }

    public void setEndMatch(JButton endMatch) {
        this.endMatch = endMatch;
    }

    //Deve criar uma nova janela com o jogo no meio, texto no topo que diz de quem é o turno ou se alguém ganhou e um buttão em baxio para voltar para a criação de jogo.
    public gamePanel(gameBoard board, String playerTurn) {
        super.setLayout(new BorderLayout());
        this.board = board;
        super.add(board, BorderLayout.CENTER);
        this.info.setText(playerTurn+"'s turn");
        this.infoPanel.add(info);
        super.add(infoPanel, BorderLayout.NORTH);
        this.endMatch.setText("Cancel Match");
        super.add(endMatch, BorderLayout.SOUTH);
    }
}
