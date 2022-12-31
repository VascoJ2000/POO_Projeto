//Class para criar as regras de jogo. Metodos para ver se um jogador ganhou, se marcou ponto.
public class scoreRules {
    private int boardSize; //Tamanho do jogo
    private int score; //Nº de quadrados seguidos para marcar pontos
    private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.

    public scoreRules(int boardSize, int score, int winScore) {
        this.boardSize = boardSize;
        this.score = score;
        this.winScore = winScore;
    }
    //Metodo que virifica se marcou ponto.
    public boolean hasScored(int position){
        return false;
    }
    //Metodo que verifica se ganhou.
    public boolean hasWon(){
        return score>=winScore;
    }
}
