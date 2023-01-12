import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

//Contém os metodos para ver se um jogador ganhou, se marcou algum ponto. Também decide de quem é o turno.
public class gameRules {
    final private int toScore; //Nº de quadrados seguidos para marcar pontos. Deve ser menor que a altura e a largura do tabuleiro.
    final private int winScore; //Nº de pontos para vencer.
    final private boolean randomTurns; //true = turnos ao calhas, false = turnos normais. Player1 começa sempre primeiro.
    private int turn = 0; //0 = player1, 1 = player2.
    private ArrayList<player> players; //Lista neste caso sempre de tamanho 2. Se ouver mais jogadores é só preciso aumentar a lista e dar um novo id(id do jogador anterior+1).
    private int usedButtons; //Usado para verificar se todos os buttões foram usados.
    private gamePanel panel; //Usado para ir buscar o tabuleiro e alterar os outros elememtos da UI a medida que o jogo vai correndo.
    private int whoWon = 0; //0 = Ninguem ainda ganhou, 1 = Player1 ganhou, 2 = Player2 ganhou, -1 = empate.

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

    public gamePanel getPanel() {
        return panel;
    }

    public void setPanel(gamePanel panel) {
        this.panel = panel;
    }

    public gameRules(String player1, String player2, int score, int winScore, boolean randomTurns) {
        setPlayers(new ArrayList<player>());
        player p1 = new player(player1, 1);
        player p2 = new player(player2, 2);
        players.add(p1);
        players.add(p2);
        this.toScore = score;
        this.winScore = winScore;
        this.randomTurns = randomTurns;
    }
    //Verifica dois lados opostos ao mesmo tempo e verifica se há quadrados suficientes em ambas
    //direções que pertenção ao mesmo jogador para marcar 1 ponto.
    //Faz isso 4 vezes para cada conjunto de direções: norte/sul, este/oeste, noreste/suldoeste e noroeste/suldeste.
    //Os varios int no inicio são para não estar a ir buscar 8 vezes valores que não mudam a outras classes.
    public void hasScored(gameButton button){
        int bw = panel.getBoard().getBoardWidth();
        int bh = panel.getBoard().getBoardHeight();
        int bp = button.getPosition();
        int bc = button.getClaim();
        int ts = getToScore();
        int checker = -1;
        int point = 0;
        //norte/sul
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp-bw*i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp-bw*i).getPositionY() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp+bw*i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp+bw*i).getPositionY() == bh-1){ break; }
        }
        if(checker >= ts){
            point++;
        }
        checker=-1;
        //este/oeste
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp-i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp-i).getPositionX() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp+i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp+i).getPositionX() == bw-1){ break; }
        }
        if(checker >= ts){
            point++;
        }
        checker=-1;
        //noreste/suldoeste
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp-(bw+1)*i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp-(bw+1)*i).getPositionX() == 0 || panel.getBoard().getButtons().get(bp-(bw+1)*i).getPositionY() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp+(bw+1)*i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp+(bw+1)*i).getPositionX() == bw-1 || panel.getBoard().getButtons().get(bp+(bw+1)*i).getPositionY() == bh-1){ break; }
        }
        if(checker >= ts){
            point++;
        }
        checker=-1;
        //noroeste/suldeste.
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp-(bw-1)*i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp-(bw-1)*i).getPositionX() == bw-1 || panel.getBoard().getButtons().get(bp-(bw-1)*i).getPositionY() == 0){ break; }
        }
        for(int i = 0; i< ts; i++){
            if(panel.getBoard().getButtons().get(bp+(bw-1)*i).getClaim() == bc){
                checker++;
            }
            if(panel.getBoard().getButtons().get(bp+(bw-1)*i).getPositionX() == 0 || panel.getBoard().getButtons().get(bp+(bw-1)*i).getPositionY() == bh-1){ break; }
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
        panel.getInfo().setText(players.get(turn).getName()+"'s turn");
    }

    //Quando o buttão é clicado o ID do player que clicou no buttão é usado para ver se este já foi usado
    //e também é verificado se alguém já ganhou. Se este for o caso o buttão passa a pertencer ao jogador
    //que o clicou e se for Player1 o texto do buttão é mudado de "" para "X" se for Player2 é mudado para
    //"O". A seguir este verifica se o jogador marcou um ponto e assinala que mais um buttão foi usado.
    //Por fim verifica se alguem ganhou o jogo se não muda o turno e se ninguém ganhou quando o tabuleiro
    //é preenchido mostra ouve um empate.
    public void buttonClick(gameButton button){
        int id = players.get(turn).getId();
        if(button.getClaim() == 0 && whoWon == 0){
            button.setClaim(id);
            button.setText(id<2 ? "X" : "O");
            button.setForeground(id<2 ? Color.red : Color.blue);
            hasScored(button);
            usedButtons++;
            if (usedButtons == panel.getBoard().getBoardSize() && players.get(0).getScore() == players.get(1).getScore()) {
                whoWon = -1;
                panel.getInfo().setText("TIE");
                panel.getInfo().setForeground(Color.green);
                panel.getEndMatch().setText("New Game");
            } else if(players.get(turn).getScore()>=getWinScore() || usedButtons == panel.getBoard().getBoardSize()){
                whoWon = players.get(0).getScore() > players.get(1).getScore() ? 1 : 2;
                panel.getInfo().setText(players.get(whoWon-1).getName()+" won");
                panel.getInfo().setForeground(whoWon<2 ? Color.red : Color.blue);
                panel.getEndMatch().setText("New Game");
            } else{
                changeTurn();
            }
        }
    }
}
