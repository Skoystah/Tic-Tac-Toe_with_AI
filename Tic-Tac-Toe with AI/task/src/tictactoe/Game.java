package tictactoe;


public class Game {

    PlayingField board;

    public void playGame() {

        startGame();
        board.printPlayingField();

        makeMove(board);
        board.printPlayingField();

        board.printState();

    }

    private void startGame() {
        // added size to constructor to make the game flexible to expand later on
        this.board = new PlayingField(3);
    }

    private void makeMove(PlayingField board) {
        Move move = new Move();
        move.enterMove(board);

        board.registerMove(move);
    }
}
