import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class gameBoard extends JPanel {
    final private int boardWidth; //Largura do tabuleiro de jogo
    final private int boardHeight; //Altura do tabuleiro de jogo
    final private int boardSize; //Area do tabuleiro de jogo
    private ArrayList<gameButton> buttons = new ArrayList<gameButton>();

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
        super(new GridLayout(boardWidth, boardHeight));
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.boardSize = boardWidth*boardHeight;
        createBoard(rules);
    }

    private void createBoard(gameRules rules){
        for(int i = 0; i<boardSize; i++){
            buttons.add(new gameButton(i, rules));
            add(buttons.get(i));
        }
    }
}
