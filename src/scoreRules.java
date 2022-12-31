//Class para criar as regras de jogo. Metodos para ver se um jogador ganhou, se marcou ponto.
public class scoreRules {
    final private int boardSize; //Tamanho do jogo
    final private int score; //Nº de quadrados seguidos para marcar pontos
    final private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.

    public scoreRules(int boardSize, int score, int winScore) {
        this.boardSize = boardSize;
        this.score = score;
        this.winScore = winScore;
    }
    //Metodo que verifica se marcou ponto.
    public boolean hasScored(int position){
        return false;
    }
    //Metodo que verifica se ganhou.
    public boolean hasWon(){
        return score>=winScore;
    }
}
