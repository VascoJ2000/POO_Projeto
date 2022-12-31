import java.util.Random;

//Class para criar as regras de jogo. Metodos para ver se um jogador ganhou, se marcou ponto.
public class gameRules {
    final private int score; //Nº de quadrados seguidos para marcar pontos
    final private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.
    final private Boolean randomTurns; //Tipo de jogo se true os turnos de cada jogador são ao calhas.
    private int turn = 0;
    private int timer; //tempo de turno para cada jogador.

    public gameRules(int score, int winScore, boolean randomTurns, int timer) {
        this.score = score;
        this.winScore = winScore;
        this.randomTurns = randomTurns;
        this.timer = timer;
    }
    //Metodo que verifica se marcou ponto.
    public boolean hasScored(int position){
        return false;
    }
    //Metodo que verifica se ganhou.
    public boolean hasWon(){
        return score>=winScore;
    }
    //Metodo para decidir de quem é o turno.
    public String whoseTurn(){
        if(randomTurns){
            Random random = new Random();
            turn = random.nextInt(2);
        }else{
            turn+= turn<2 ? 1 : -1;
        }
        return "player"+turn;
    }
}
