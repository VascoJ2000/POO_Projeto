import java.util.Random;

//Class para criar as regras de jogo. Metodos para ver se um jogador ganhou, se marcou ponto.
public class gameRules {
    final private int score; //Nº de quadrados seguidos para marcar pontos
    final private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.
    final private boolean randomTurns; //Tipo de jogo se true os turnos de cada jogador são ao calhas.
    private int NumOfPlayers = 0;
    private String turn;
    private int timer; //tempo de turno para cada jogador.

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public gameRules(int score, int winScore, boolean randomTurns, int timer) {
        this.score = score;
        this.winScore = winScore;
        this.randomTurns = randomTurns;
        this.timer = timer;
    }
    //Metodo que verifica se marcou ponto.
    public boolean hasScored(){
        return false;
    }
    //Metodo que verifica se ganhou.
    public boolean hasWon(){
        return this.score>=this.winScore;
    }
    //Metodo para decidir de quem é o turno.
    public String whoseTurn(){
        if(this.randomTurns){
            Random random = new Random();
            this.NumOfPlayers = random.nextInt(2);
        }else{
            this.NumOfPlayers += this.NumOfPlayers <2 ? 1 : -1;
        }
        this.turn = "player"+ this.NumOfPlayers;
        return this.turn;
    }
}
