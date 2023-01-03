import java.util.ArrayList;
import java.util.Random;

//Class para criar as regras de jogo. Metodos para ver se um jogador ganhou, se marcou ponto.
public class gameRules {
    final private int score; //Nº de quadrados seguidos para marcar pontos
    final private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.
    final private boolean randomTurns; //Tipo de jogo se true os turnos de cada jogador são ao calhas.
    private int turn = 0; //De quem é o turno.
    private int timer; //tempo de turno para cada jogador.
    private ArrayList<player> players; //Lista neste caso sempre de tamanho 2.

    public int getScore() {
        return score;
    }

    public int getWinScore() {
        return winScore;
    }

    public boolean isRandomTurns() {
        return randomTurns;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public ArrayList<player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<player> players) {
        this.players = players;
    }

    public gameRules(String player1, String player2, int score, int winScore, boolean randomTurns, int timer) {
        setPlayers(new ArrayList<player>());
        player p1 = new player(player1, 1);
        player p2 = new player(player2, 2);
        players.add(p1);
        players.add(p2);
        this.score = score;
        this.winScore = winScore;
        this.randomTurns = randomTurns;
        this.timer = timer;
    }
    //Metodos que verificam se marcou ponto.
    public void hasScored(gameButton button){
        /*int points = hasScoredLine(board, button, board.getBoardWidth()) + hasScoredLine(board, button, 1) + hasScoredLine(board, button, board.getBoardWidth()+1) + hasScoredLine(board, button, board.getBoardWidth()-1);
        if(points > 0){
            player.setScore(getScore()+points);
        }*/
    }
    private int hasScoredLine(gameBoard board, gameButton button, int x){
        int checker = 1;
        for(int i = 1; i<this.score; i++){
            if(board.getButtons().get(button.getPosition()+x*i).getClaim() == button.getClaim()){
                checker++;
            }else{
                break;
            }
        }
        for(int i = 1; i<this.score; i++){
            if(board.getButtons().get(button.getPosition()-x*i).getClaim() == button.getClaim()){
                checker++;
            }else{
                break;
            }
        }
        if(checker >= this.score){
            checker = checker/this.score;
        }
        return checker;
    }

    //Metodo que verifica se ganhou.
    public boolean hasWon(player player){
        return player.getScore()>=this.winScore;
    }
    //Metodo para decidir de quem é o turno.
    public void changeTurn(){
        if(this.randomTurns){
            Random random = new Random();
            this.turn = random.nextInt(2);
        }else{
            this.turn = this.turn <1 ? 1 : 0;
        }
    }

    public void buttonClick(gameButton button){
        if(button.getClaim() == 0){
            button.setClaim(players.get(turn).getTurnNumber());
            button.setText(players.get(turn).getTurnNumber()<2 ? "X" : "O");
            hasScored(button);
            if(hasWon(players.get(turn))){
                ;
            }else {
                changeTurn();
            }
        }
    }
}
