public class player {

    //Não tem nenhuma porposito funcional apenas serve para em vez de aparecer player1 ou player2 na UI
    //do jogo aparece um nome.
    private String name;
    private int score = 0;//Usado para guardar os pontos de cada jogador ao longo do jogo.
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
