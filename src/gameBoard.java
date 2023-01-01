public class gameBoard {
    final private int boardWidth; //Largura do tabuleiro de jogo
    final private int boardHeight; //Altura do tabuleiro de jogo

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public gameBoard(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
}
