package tictactoe;


public class Game {

    PlayingField board;
    Player[] players = new Player[2];
    Player phasingPlayer;
    Move move = new Move();


    public void startGame(String[] inputPlayers) {

        addPlayers(inputPlayers);

        setupBoard();
        board.printPlayingField();

        while (!board.isFinished()) {
            phasingPlayer.makeMove(board);
            board.printPlayingField();
            switchPhasingPlayer();
        }

        board.printState();

    }

    private void addPlayers(String[] inputPlayers) {

        for (int i = 0; i < inputPlayers.length; i++) {
            Player[] availablePlayers = new Player[]{new HumanPlayer(),
                    new EasyAIPlayer(), new MediumAIPlayer()};
            for (Player a : availablePlayers) {
                if (inputPlayers[i].equals(a.getKeyword())) {
                    this.players[i] = a;
                    this.players[i].assignSymbol(PlayerSymbol.lookupSymbolByPosition(i));
                    break;
                }
            }
        }

        this.phasingPlayer = this.players[0];
    }

    private void setupBoard() {

        // added size to constructor to make the game flexible to expand later on
        this.board = new PlayingField(3);
    }

    private void switchPhasingPlayer() {
        for (int i = 0; i < players.length; i++) {
            if (phasingPlayer == players[i]) {
                if (i < players.length - 1) {
                    phasingPlayer = players[i + 1];
                    break;
                } else {
                    phasingPlayer = players[0];
                    break;
                }
            }
        }
    }
}
