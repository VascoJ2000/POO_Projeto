import java.util.ArrayList;
import java.util.Random;

//Class para criar as regras de jogo. Metodos para ver se um jogador ganhou, se marcou ponto.
public class gameRules {
    final private int toScore; //Nº de quadrados seguidos para marcar pontos
    final private int winScore; //Nº de pontos para vencer. se -1 deixar o tabuleiro ser preenchido.
    final private boolean randomTurns; //Tipo de jogo se true os turnos de cada jogador são ao calhas.
    private int turn = 0; //De quem é o turno.
    private int timer; //tempo de turno para cada jogador.
    private ArrayList<player> players; //Lista neste caso sempre de tamanho 2.
    private int usedButtons; //Nº de buttões que foram usados.
    private gameBoard board;
    private int whoWon = 0; //0 = Ninguem ganhou, 1 = Player1 ganhou, 2 = Player2 ganhou.

    public int getToScore() {
        return toScore;
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

    public int getUsedButtons() {
        return usedButtons;
    }

    public void setUsedButtons(int usedButtons) {
        this.usedButtons = usedButtons;
    }

    public gameBoard getBoard() {
        return board;
    }

    public void setBoard(gameBoard board) {
        this.board = board;
    }

    public gameRules(String player1, String player2, int score, int winScore, boolean randomTurns, int timer) {
        setPlayers(new ArrayList<player>());
        player p1 = new player(player1, 1);
        player p2 = new player(player2, 2);
        players.add(p1);
        players.add(p2);
        this.toScore = score;
        this.winScore = winScore;
        this.randomTurns = randomTurns;
        this.timer = timer;
    }
    //Metodos que verificam se marcou ponto.
    public void hasScored(gameButton button){
        int bw = board.getBoardWidth();
        int bh = board.getBoardHeight();
        int bp = button.getPosition();
        int bc = button.getClaim();
        int ts = getToScore();
        int checker = -1;
        int point = 0;
        //norte/sul
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp-bw*i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp-bw*i).getPositionY() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp+bw*i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp+bw*i).getPositionY() == bh-1){ break; }
        }
        if(checker >= ts){
            point++;
        }
        checker=-1;
        //este/oeste
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp-i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp-i).getPositionX() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp+i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp+i).getPositionX() == bw-1){ break; }
        }
        if(checker >= ts){
            point++;
        }
        checker=-1;
        //noreste/suldoeste
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp-(bw+1)*i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp-(bw+1)*i).getPositionX() == 0 || board.getButtons().get(bp-(bw+1)*i).getPositionY() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp+(bw+1)*i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp+(bw+1)*i).getPositionX() == bw-1 || board.getButtons().get(bp+(bw+1)*i).getPositionY() == bh-1){ break; }
        }
        if(checker >= ts){
            point++;
        }
        checker=-1;
        //noroeste/suldeste.
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp-(bw-1)*i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp-(bw-1)*i).getPositionX() == bw-1 || board.getButtons().get(bp-(bw-1)*i).getPositionY() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(board.getButtons().get(bp+(bw-1)*i).getClaim() == bc){
                checker++;
            }
            if(board.getButtons().get(bp+(bw-1)*i).getPositionX() == 0 || board.getButtons().get(bp+(bw-1)*i).getPositionY() == bh-1){ break; }
        }
        if(checker >= ts){
            point++;
        }
        players.get(turn).setScore(players.get(turn).getScore()+point);

    }
    public boolean hasWon(player player){
        return player.getScore()>=getWinScore();
    }
    //Metodo para decidir de quem é o turno.
    public void changeTurn(){
        if(this.randomTurns){
            Random random = new Random();
            setTurn(random.nextInt(2));
        }else{
            setTurn(getTurn()<1 ? 1 : 0);
        }
    }

    public void buttonClick(gameButton button){
        int id = players.get(turn).getId();
        if(button.getClaim() == 0 && whoWon == 0){
            button.setClaim(id);
            button.setText(id<2 ? "X" : "O");
            hasScored(button);
            usedButtons++;
            if(!(players.get(turn).getScore()>=getWinScore())){
                changeTurn();
            }else{
                whoWon = id;
            }
        }
    }
}
