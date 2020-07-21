package tictactoe;

public class MediumAIPlayer implements Player {

    private PlayerSymbol symbol;
    private final String keyword = "medium";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public PlayerSymbol getSymbol() {
        return symbol;
    }

    @Override
    public void assignSymbol(PlayerSymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(PlayingField board) {
    }

}
