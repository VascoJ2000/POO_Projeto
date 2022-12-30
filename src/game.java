import javax.swing.*;

public class game {
    private player player1;
    private player player2;
    private int boardSize; //Tamanho do jogo
    private int score; //Nº de quadrados seguidos para marcar pontos
    private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.
    private int timer;
    /*tipo de jogo(gameType):
    -Normal: cada pessoa tem um turno de cada vez.
    -random turns: o proximo turno é ao calhas e decidido pela maquina.
     (só para implementar se ouver tempo)*/
    private String gameType;

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

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public game(player player1, player player2, int boardSize, int score, int winScore, int timer, String gameType) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardSize = boardSize;
        this.score = score;
        this.winScore = winScore;
        this.timer = timer;
        this.gameType = gameType;
    }
}
