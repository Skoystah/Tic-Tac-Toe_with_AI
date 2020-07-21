package tictactoe;


public class Move {

    private int column;
    private int row;

    public void enterMove(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

}
