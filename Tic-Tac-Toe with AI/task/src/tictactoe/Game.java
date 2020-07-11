package tictactoe;


public class Game {

    PlayingField board;

    public void playGame() {

        startGame();
        board.printPlayingField();

        while (!board.isFinished()) {
            makeMove(board);
            board.printPlayingField();
        }

        board.printState();

    }

    private void startGame() {
        // added size to constructor to make the game flexible to expand later on
        this.board = new PlayingField(3);
    }

    private void makeMove(PlayingField board) {
        Move move = new Move();
        if (board.getPhasingPlayer() == 'X') { // human player - to expand later
            move.playerMove(board);
        } else {
            move.computerMove(board);
        }

        board.registerMove(move);
    }
}
