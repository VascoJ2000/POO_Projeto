import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel gamePanel;
    private JPanel inGamePanel;
    private JPanel gameBoardPanel;
    private JPanel gameScorePanel;
    private JComboBox timerBox;
    private JLabel timerLabel;
    private JPanel playerTurnPanel;
    private JPanel turnTimerPanel;
    private JProgressBar timerProgressBar;
    private JLabel timerProgressLabel;
    private JLabel playerTurnLabel;
    private JButton buttonCancel;
    private JComboBox widthBox;
    private JLabel widthLabel;
    private JLabel heightLabel;

    public JPanel getGamePanel() {
        return gamePanel;
    }

    //Clicar no buttão "Start" deve criar o jogo e começar o jogo.
    //Clicar no buttão "Cancel Match" deve acabar o jogo sem ninguem ganhar ou perder.
    public gameGUI() {
        //"Start" cria as regras e o tabuleiro de acordo com o pedido no ecrã de pre-jogo.
        //Este ainda muda o ecrã do de pre-jogo para o de jogo.
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameRules rules = new gameRules(player1Name.getText(), player2Name.getText(), scoreBox.getSelectedIndex()+3, winScoreBox.getSelectedIndex()+1, ((String)gameTypeBox.getSelectedItem()).equals("Random Turns"), (timerBox.getSelectedIndex()+1)*30);
                gameBoard board = new gameBoard(widthBox.getSelectedIndex()+3, heightBox.getSelectedIndex()+3, rules);
                rules.setBoard(board);
                gameBoardPanel = board;
                gameBoardPanel.setVisible(true);
                CardLayout cl = (CardLayout) gamePanel.getLayout();
                cl.show(gamePanel, "inGamePanel");
            }
        });
        //"Cancel Match" acaba com o jogo e muda o ecrã de volta para o de pre-jogo para deixar um novo jogo ser criado.
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) gamePanel.getLayout();
                cl.show(gamePanel, "preGamePanel");
            }
        });
    }
}
