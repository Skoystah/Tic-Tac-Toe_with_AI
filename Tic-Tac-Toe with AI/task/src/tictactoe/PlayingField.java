package tictactoe;

public class PlayingField {
    private final Square[][] board;
    private final int size;

    private int numberOfX = 0;
    private int numberOfO = 0;
    private Player phasingPlayer;

    public Player getPhasingPlayer() {
        return phasingPlayer;
    }

    public void setPhasingPlayer(Player player) {
        this.phasingPlayer = player;
    }

    public int getSize() {
        return size;
    }

    public PlayingField(int size) {
        this.board = new Square[size][size];
        this.size = size;

        int column = 1;
        int row = 3;
        int symbol = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Square(column, row, ' ');
                symbol++;
                column++;
            }

            column = 1;
            row--;
        }

    }

    public void printPlayingField() {
        System.out.println("---------");

        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.print("|\n");
        }

        System.out.println("---------");
    }

    public boolean isEmptySquare(int column, int row) {
        for (Square[] s : board) {
            for (Square s2 : s) {
                if (s2.getColumn() == column && s2.getRow() == row) {
                    return(s2.getSymbol() == ' ');
                }
            }
        }
        return false;
    }

    private boolean isFullBoard() {
        for (Square[] s : board) {
            for (Square s2 : s) {
                if (s2.getSymbol() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void registerMove(Move move) {
        for (Square[] s : board) {
            for (Square s2 : s) {
                if (s2.getColumn() == move.getColumn() && s2.getRow() == move.getRow()) {
                    s2.setSymbol(move.getPlayer().getSymbol());
                }
            }
        }

//        switchPhasingPlayer();
    }

//    private void switchPhasingPlayer() {
//        if (this.phasingPlayer == 'X')
//            this.phasingPlayer = 'O';
//        else
//            this.phasingPlayer = 'X';
//    }

    public void printState() {
        switch (determineState()) {
            case 'X':
                System.out.println("X wins");
                break;
            case 'O':
                System.out.println("O wins");
                break;
            case '/':
                System.out.println("Game not finished");
                break;
            case '=':
                System.out.println("Draw");
                break;
            default :
                System.out.println("I haven't got a clue what the situation is! :(");
        }
    }

    private char determineState() {
        // Temp -> to be refactored to support size > 3!
        // Check column for win
        for (int i = 0; i < size; i++) {
            for (int j = 0; j + 2 < size; j++) {
                if (board[i][j].getSymbol() > ' ' &&
                        board[i][j].getSymbol() == board[i][j + 1].getSymbol() &&
                        board[i][j].getSymbol() == board[i][j + 2].getSymbol()) {
                    return (board[i][j].getSymbol());
                }
            }
        }
        // Check row for win
        for (int j = 0; j < size; j++) {
            for (int i = 0; i + 2 < size; i++) {
                if (board[i][j].getSymbol() > ' ' &&
                        board[i][j].getSymbol() == board[i+1][j].getSymbol() &&
                        board[i][j].getSymbol() == board[i+2][j].getSymbol()) {
                    return (board[i][j].getSymbol());
                }
            }
        }
        // Check diagonal top L -> bottom R for win
        for (int i = 0; i + 2 < size; i++) {
            for (int j = 0; j + 2 < size; j++) {
                if (board[i][j].getSymbol() > ' ' &&
                        board[i][j].getSymbol() == board[i+1][j+1].getSymbol() &&
                        board[i][j].getSymbol() == board[i+2][j+2].getSymbol()) {
                    return (board[i][j].getSymbol());
                }
            }
        }

        // Check diagonal bottom L -> top R for win
        for (int i = size - 1; i - 2 >= 0; i--) {
            for (int j = 0; j + 2 < size; j++) {
                if (board[i][j].getSymbol() > ' ' &&
                        board[i][j].getSymbol() == board[i-1][j+1].getSymbol() &&
                        board[i][j].getSymbol() == board[i-2][j+2].getSymbol()) {
                    return (board[i][j].getSymbol());
                }
            }
        }

        // If no winner, check if the game is a draw (full board) or not.
        // '=' -> draw
        // '/' -> game unfinished
        return (isFullBoard() ? '=' : '/');
    }

    public boolean isFinished() {
        return (determineState() == '/' ? false : true);
    }
}
