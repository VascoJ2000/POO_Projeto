import javax.swing.*;
import java.awt.*;

//Game é o psvm deste projecto é suposto criar a janela onde o painel da gameGUI é criado.
public class game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setMinimumSize(new Dimension(1000, 500));
        frame.setMaximumSize(new Dimension(1000, 500));
        frame.setContentPane(new gameGUI().getCardPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
