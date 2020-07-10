package tictactoe;

public class Square {
    private final int column;
    private final int row;
    private char symbol;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public Square(int column, int row, char symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol == '_' ? ' ' : symbol;
    }
}
