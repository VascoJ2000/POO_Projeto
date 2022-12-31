import java.util.*;

public class game {
    private ArrayList<player> players; //Lista neste caso sempre de tamanho 2.
    private gameRules rules;
    private board board;

    public ArrayList<player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<player> players) {
        this.players = players;
    }

    public gameRules getRules() {
        return rules;
    }

    public void setRules(gameRules rules) {
        this.rules = rules;
    }

    public board getBoard() {
        return board;
    }

    public void setBoard(board board) {
        this.board = board;
    }

    public game(String player1, String player2, int height, int width, int score, int winScore, int timer, String gameType) {
        setPlayers(new ArrayList<player>());
        player p1 = new player(player1);
        player p2 = new player(player2);
        players.add(p1);
        players.add(p2);
        setRules(new gameRules(score, winScore, gameType.equals("Random Turns"), timer));
        setBoard(new board(width, height));
    }
}
