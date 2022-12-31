import java.util.ArrayList;

public class game {
    private ArrayList<player> players; //Lista neste caso sempre de tamanho 2.
    private scoreRules rules;
    private int timer; //tempo de turno para cada jogador.
    /*tipo de jogo(gameType):
    -Normal: cada pessoa tem um turno de cada vez.
    -random turns: o proximo turno é ao calhas e decidido pela maquina.
     (só para implementar se ouver tempo)*/
    private String gameType;

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

    public ArrayList<player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<player> players) {
        this.players = players;
    }

    public scoreRules getRules() {
        return rules;
    }

    public void setRules(scoreRules rules) {
        this.rules = rules;
    }

    public game(String player1, String player2, int boardSize, int score, int winScore, int timer, String gameType) {
        setPlayers(new ArrayList<player>());
        player p1 = new player(player1);
        player p2 = new player(player2);
        players.add(p1);
        players.add(p2);
        setRules(new scoreRules(boardSize, score, winScore));
        this.timer = timer;
        this.gameType = gameType;
    }
}
