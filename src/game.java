import javax.swing.*;
import java.awt.*;
import java.util.*;

//Game é o psvm deste projecto é suposto criar a janela onde o painel da gameGUI é criado.
public class game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setContentPane(new gameGUI().getGamePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    //**************************PARA TESTAR O JOGO SOZINHO*****************************//
    //temp PVSM para testar a maioria das coisas aqui deveriam estar no gameGUI,
    //estão aqui pois não consigo por a janela de jogo no gameGUI e preciso de o testar.
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setMinimumSize(new Dimension(1000, 500));
        frame.setMaximumSize(new Dimension(1000, 500));
        frame.setResizable(false);
        gameRules rules = new gameRules("player1", "player2", 3, 1, false, 30);
        gameBoard board = new gameBoard(10, 5, rules);
        frame.setContentPane(board);
        rules.setBoard(board);
        rules.changeTurn();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/
}
