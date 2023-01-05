import java.util.ArrayList;
import java.util.Random;

//Contém os metodos para ver se um jogador ganhou, se marcou algum ponto. Também decide de quem é o turno.
public class gameRules {
    final private int toScore; //Nº de quadrados seguidos para marcar pontos
    final private int winScore; //0 = deixar o tabuleiro ser prenchido, >0 = numero de pontos para vencer.
    final private boolean randomTurns; //true = turnos ao calhas, false = turnos normais.
    private int turn = 0; //0 = player1, 1 = player2.
    private int timer; //s.
    private ArrayList<player> players; //Lista neste caso sempre de tamanho 2.
    private int usedButtons; //Usado para verificar se todos os buttões foram usados.
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
    //Verifica dois lados opostos ao mesmo tempo e verifica se há quadrados suficientes em ambas
    //direções que pertenção ao mesmo jogador para marcar 1 ponto.
    //Faz isso 4 vezes para cada conjunto de direções: norte/sul, este/oeste, noreste/suldoeste e noroeste/suldeste.
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

    //Se randomTurns for true usa a função random para decidir de quem é o turno, se não os turnos
    //seguem normalmente (player1 seguido de player2 seguido de player1 seguido de player2...).
    public void changeTurn(){
        if(this.randomTurns){
            Random random = new Random();
            setTurn(random.nextInt(2));
        }else{
            setTurn(getTurn()<1 ? 1 : 0);
        }
    }

    //Quando o buttão é clicado o ID do player que clicou no buttão é usado para ver se este já foi usado
    //e também é verificado se alguém já ganhou. Se este for o caso o buttão passa a pertencer ao jogador
    //que o clicou e se for Player1 o texto do buttão é mudado de "" para "X" se for Player2 é mudado para
    //"O". A seguir este verifica se o jogador marcou um ponto e assinala que mais um buttão foi usado.
    //Por fim verifica se alguem ganhou o jogo se não muda o turno.
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
