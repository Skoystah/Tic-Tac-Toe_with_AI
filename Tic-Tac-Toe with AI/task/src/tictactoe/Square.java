package tictactoe;

public class Square {
    private final int column;
    private final int row;
    private PlayerSymbol symbol;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setSymbol(PlayerSymbol symbol) {
        this.symbol = symbol;
    }

    public PlayerSymbol getSymbol() {
        return symbol;
    }

    public Square(int column, int row, PlayerSymbol symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }
}
