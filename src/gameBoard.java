import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class gameBoard extends JPanel {
    final private int boardWidth; //Nº de colunas.
    final private int boardHeight; //Nº de linhas.
    final private int boardSize; //Nº de quadrados. Usado para saber
    private ArrayList<gameButton> buttons = new ArrayList<gameButton>(); //Lista usada para colocar os buttões no tabuleiro e para os encontrar.

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public ArrayList<gameButton> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<gameButton> buttons) {
        this.buttons = buttons;
    }

    public gameBoard(int boardWidth, int boardHeight, gameRules rules) {
        super(new GridLayout(boardHeight, boardWidth));
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.boardSize = boardWidth*boardHeight;
        createBoard(rules);
    }

    //Cria um todos os buttões que serão usados no tabuleiro atribuindo-lhes a linha, a coluna, a posição
    //geral no tabuleiro e as regras que vai usar.
    private void createBoard(gameRules rules){
        for(int i = 0; i<boardHeight; i++){
            for(int j = 0; j<boardWidth; j++) {
                buttons.add(new gameButton(j, i, boardWidth*i+j, rules));
                add(buttons.get(boardWidth*i+j));
            }
        }
    }
}
