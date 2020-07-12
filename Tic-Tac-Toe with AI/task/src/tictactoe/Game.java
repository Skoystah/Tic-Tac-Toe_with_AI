package tictactoe;


public class Game {

    PlayingField board;
    Player playerOne;
    Player playerTwo;


    public void startGame(String[] players) {

        addPlayers(players);

        setupBoard();
        board.printPlayingField();

        while (!board.isFinished()) {
            makeMove(board);
            board.printPlayingField();
        }

        board.printState();

    }

    private void addPlayers(String[] players) {
        this.playerOne = new Player(players[0], 'X');
        this.playerTwo = new Player(players[1], 'O');
    }

    private void setupBoard() {

        // added size to constructor to make the game flexible to expand later on
        this.board = new PlayingField(3);
        // set first player as phasing player
        board.setPhasingPlayer(this.playerOne);
    }

    private void makeMove(PlayingField board) {
        Move move = new Move();
        if (board.getPhasingPlayer().getType() == "human") { // human player - to expand later
            move.playerMove(board);
        } else {
            move.computerMove(board);
        }

        board.registerMove(move);

        if (board.getPhasingPlayer() == playerOne) {
            board.setPhasingPlayer(playerTwo);
        } else {
            board.setPhasingPlayer(playerOne);
        }
    }
}
