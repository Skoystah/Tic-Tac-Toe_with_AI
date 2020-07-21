package tictactoe;

import java.util.Random;

public class EasyAIPlayer implements Player {

    private PlayerSymbol symbol;
    private final String keyword = "easy";
    private Move move = new Move();

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
        Random rand = new Random();
        do {
            int column = rand.nextInt(3) + 1;
            int row = rand.nextInt(3) + 1;
            move.enterMove(column, row);
        } while (!board.isValidAIMove(move));

        board.registerMove(move, this);
        System.out.printf("Making move level \"%s\"%n", keyword);

    }

}
