import javax.swing.*;
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
    private JComboBox boardBox;
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
    private JButton board;

    //Clicar no buttão "Start" deve criar o jogo e começar o jogo.
    public gameGUI() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
