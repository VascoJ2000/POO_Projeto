import javax.swing.*;

public class board {
    final private int boardWidth; //Largura do tabuleiro de jogo
    final private int boardHeight; //Altura do tabuleiro de jogo

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public board(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    //Metodo que cria o tabuleiro.
    public JButton[][] getBoard(){
        JButton[][] board = new JButton[getBoardHeight()][getBoardWidth()];
        for(int i = 0; i<getBoardHeight(); i++){
            for (int j = 0; j<getBoardWidth(); j++){
                board[i][j].setText("");
            }
        }
        return board;
    }
}
