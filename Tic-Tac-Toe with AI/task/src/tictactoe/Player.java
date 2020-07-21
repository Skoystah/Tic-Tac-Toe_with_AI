package tictactoe;

public interface Player {

    String getKeyword();

    PlayerSymbol getSymbol();

    void assignSymbol(PlayerSymbol symbol);

    void makeMove(PlayingField board);

}
