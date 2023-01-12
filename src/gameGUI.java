import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameGUI {

    private JButton startButton;
    private JPanel preGamePanel;
    private JPanel startPanel;
    private JPanel gameTypePanel;
    private JLabel gameTypeLabel;
    private JComboBox gameTypeBox;
    private JPanel playersPanel;
    private JTextField player1Name;
    private JTextField player2Name;
    private JLabel player1Label;
    private JLabel player2Label;
    private JPanel boardPanel;
    private JComboBox heightBox;
    private JLabel boardLabel;
    private JPanel winPanel;
    private JComboBox scoreBox;
    private JLabel scoreLabel;
    private JComboBox winScoreBox;
    private JLabel winScoreLabel;
    private JPanel CardPanel;
    private JPanel gameBoardPanel;
    private JButton buttonCancel;
    private JComboBox widthBox;
    private JLabel widthLabel;
    private JLabel heightLabel;

    public JPanel getCardPanel() {
        return CardPanel;
    }

    //Clicar no buttão "Start" deve criar o jogo e começar o jogo.
    //Clicar no buttão "Cancel Match" deve acabar o jogo sem ninguem ganhar ou perder.
    public gameGUI() {
        //"Start" cria as regras e o tabuleiro de acordo com o pedido no ecrã de pre-jogo.
        //Este ainda muda o ecrã do de pre-jogo para o de jogo.
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameRules rules = new gameRules(player1Name.getText(), player2Name.getText(), scoreBox.getSelectedIndex()+3, winScoreBox.getSelectedIndex()+1, ((String)gameTypeBox.getSelectedItem()).equals("Random Turns"));
                gameBoard board = new gameBoard(widthBox.getSelectedIndex()+3, heightBox.getSelectedIndex()+3, rules);
                gamePanel panel = new gamePanel(board, player1Name.getText());
                rules.setPanel(panel);
                CardPanel.add(panel, "inGamePanel");
                CardPanel.validate();
                CardPanel.repaint();
                CardLayout cl = (CardLayout) CardPanel.getLayout();
                //Listener que é suposto acabar com o jogo e voltar para o primeiro ecrã
                MouseListener goBack = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cl.show(CardPanel, "preGamePanel");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                };
                panel.getEndMatch().addMouseListener(goBack);
                cl.show(CardPanel, "inGamePanel");
            }
        });
    }
}
