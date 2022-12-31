import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

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
    private JButton[][] board;

    //Clicar no buttão "Start" deve criar o jogo e começar o jogo.
    //Clicar no buttão "Cancel Match" deve acabar o jogo sem ningem ganhar ou perder.
    public gameGUI() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game jogo = new game(player1Name.getText(), player2Name.getText(), (heightBox.getSelectedIndex()+3)*(widthBox.getSelectedIndex()+3), scoreBox.getSelectedIndex()+3, winScoreBox.getSelectedIndex()+1, (timerBox.getSelectedIndex()+1)*30, gameTypeBox.getToolTipText());
                CardLayout cl = (CardLayout) gamePanel.getLayout();
                cl.show(gamePanel, "inGamePanel");
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) gamePanel.getLayout();
                cl.show(gamePanel, "preGamePanel");
            }
        });
    }
}
