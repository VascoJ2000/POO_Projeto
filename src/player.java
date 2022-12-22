public class player {

    private String name;
    private int currentScore;
    private int wins;
    private int bestScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    //player só tem nome no construtor pois os seus pontos iniciais vão sempre ser 0.
    public player(String name) {
        this.name = name;
        this.currentScore = 0;
        this.wins = 0;
        this.bestScore = 0;
    }
}
