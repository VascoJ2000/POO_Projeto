import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class game {

    private player player1;
    private player player2;
    private int boardSize; //Tamanho do jogo
    private int score; //Nº de quadrados seguidos para marcar pontos
    private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.
    /*tipo de jogo(gameType):
    -Normal: cada pessoa tem um turno de cada vez.
    -random turns: o proximo turno é ao calhas e decidido pela maquina.
     (só para implementar se ouver tempo)*/
    private String gameType;

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
    private JPanel game3x3;
    private JPanel game4x4;
    private JPanel game5x5;
    private JPanel game6x6;
    private JPanel game7x7;
    private JPanel game8x8;
    private JPanel game9x9;
    private JButton button1;
    private JPanel gameBoardPanel;
    private JPanel gameScorePanel;

    public player getPlayer1() {
        return player1;
    }

    public void setPlayer1(player player1) {
        this.player1 = player1;
    }

    public player getPlayer2() {
        return player2;
    }

    public void setPlayer2(player player2) {
        this.player2 = player2;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWinScore() {
        return winScore;
    }

    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public game(player player1, player player2, int boardSize, int score, int winScore, String gameType) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardSize = boardSize;
        this.score = score;
        this.winScore = winScore;
        this.gameType = gameType;
    }

    //Clicar no buttão "Start" deve criar o jogo e começar o jogo.
    public game() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
