import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameGUI {
    private game newGame;

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

    public void setBoard(JButton[][] board) {
        this.board = board;
    }

    public game getNewGame() {
        return newGame;
    }

    public void setNewGame(game newGame) {
        this.newGame = newGame;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setContentPane(new gameGUI().gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Clicar no buttão "Start" deve criar o jogo e começar o jogo.
    //Clicar no buttão "Cancel Match" deve acabar o jogo sem ninguem ganhar ou perder.
    public gameGUI() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewGame(new game(player1Name.getText(), player2Name.getText(), heightBox.getSelectedIndex()+3, widthBox.getSelectedIndex()+3, scoreBox.getSelectedIndex()+3, winScoreBox.getSelectedIndex()+1, (timerBox.getSelectedIndex()+1)*30, (String)gameTypeBox.getSelectedItem()));
                setBoard(createBoard());
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

    //Metodo que cria o tabuleiro.
    public JButton[][] createBoard(){
        JButton[][] board = new JButton[getNewGame().getBoard().getBoardHeight()][getNewGame().getBoard().getBoardWidth()];
        for(int i = 0; i<getNewGame().getBoard().getBoardHeight(); i++){
            for (int j = 0; j<getNewGame().getBoard().getBoardWidth(); j++){
                JButton button = new JButton();
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                board[i][j] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(((JButton)e.getSource()).getText().equals("")){
                            button.setText(getNewGame().getRules().getTurn());
                            getNewGame().getRules().hasScored();
                            getNewGame().getRules().hasWon();
                            getNewGame().getRules().whoseTurn();
                        }
                    }
                });
            }
        }
        return board;
    }
}
