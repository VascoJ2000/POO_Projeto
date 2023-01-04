public class player {

    private String name;
    private int score = 0;
    private final int id; //Se 1 = player1. Se 2 = player2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public player(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
