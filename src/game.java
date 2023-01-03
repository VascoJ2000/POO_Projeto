import javax.swing.*;
import java.awt.*;
import java.util.*;

public class game {
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setContentPane(new gameGUI().getGamePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/
    //temp PVSM para testar a maioria das coisas aqui deveriam estar no gameGUI,
    //estão aqui pois não consigo por a janela de jogo no gameGUI e preciso de o testar.
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setMinimumSize(new Dimension(1000, 500));
        frame.setMaximumSize(new Dimension(1000, 500));
        frame.setResizable(false);
        gameRules rules = new gameRules("player1", "player2", 1, 1, false, 30);
        frame.setContentPane(new gameBoard(10, 10, rules));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
