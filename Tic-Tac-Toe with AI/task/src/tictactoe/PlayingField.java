package tictactoe;

public class PlayingField {
    private final Square[][] board;
    private final int size;

//    private Player phasingPlayer;
//
//    public Player getPhasingPlayer() {
//        return phasingPlayer;
//    }
//
//    public void setPhasingPlayer(Player player) {
//        this.phasingPlayer = player;
//    }

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
                board[i][j] = new Square(column, row, PlayerSymbol.EMPTY);
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
                System.out.print(board[i][j].getSymbol().PlayerSymbolName() + " ");
            }
            System.out.print("|\n");
        }

        System.out.println("---------");
    }

    public boolean isEmptySquare(int column, int row) {
        for (Square[] s : board) {
            for (Square s2 : s) {
                if (s2.getColumn() == column && s2.getRow() == row) {
                    return(s2.getSymbol() == PlayerSymbol.EMPTY);
                }
            }
        }
        return false;
    }

    private boolean isFullBoard() {
        for (Square[] s : board) {
            for (Square s2 : s) {
                if (s2.getSymbol() == PlayerSymbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidHumanMove(Move move) {
        if (move.getColumn() >= 1 && move.getColumn() <= this.size &&
                move.getRow() >= 1 && move.getRow() <= this.size) {
        } else {
            System.out.printf("Coordinates should be from 1 to %d!", this.size);
            return false;
        }

        if (!isEmptySquare(move.getColumn(), move.getRow())) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public boolean isValidAIMove(Move move) {
        if (isEmptySquare(move.getColumn(), move.getRow())) {
            return true;
        }
        return false;
    }

    public void registerMove(Move move, Player player) {
        for (Square[] s : board) {
            for (Square s2 : s) {
                if (s2.getColumn() == move.getColumn() && s2.getRow() == move.getRow()) {
                    s2.setSymbol(player.getSymbol());
                }
            }
        }

    }

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
        // TODO -> to be refactored to support size > 3!
        // Check column for win
        for (int i = 0; i < size; i++) {
            for (int j = 0; j + 2 < size; j++) {
                if (board[i][j].getSymbol() != PlayerSymbol.EMPTY &&
                        board[i][j].getSymbol() == board[i][j + 1].getSymbol() &&
                        board[i][j].getSymbol() == board[i][j + 2].getSymbol()) {
                    return (board[i][j].getSymbol().PlayerSymbolName());
                }
            }
        }
        // Check row for win
        for (int j = 0; j < size; j++) {
            for (int i = 0; i + 2 < size; i++) {
                if (board[i][j].getSymbol() != PlayerSymbol.EMPTY &&
                        board[i][j].getSymbol() == board[i+1][j].getSymbol() &&
                        board[i][j].getSymbol() == board[i+2][j].getSymbol()) {
                    return (board[i][j].getSymbol().PlayerSymbolName());
                }
            }
        }
        // Check diagonal top L -> bottom R for win
        for (int i = 0; i + 2 < size; i++) {
            for (int j = 0; j + 2 < size; j++) {
                if (board[i][j].getSymbol() != PlayerSymbol.EMPTY &&
                        board[i][j].getSymbol() == board[i+1][j+1].getSymbol() &&
                        board[i][j].getSymbol() == board[i+2][j+2].getSymbol()) {
                    return (board[i][j].getSymbol().PlayerSymbolName());
                }
            }
        }

        // Check diagonal bottom L -> top R for win
        for (int i = size - 1; i - 2 >= 0; i--) {
            for (int j = 0; j + 2 < size; j++) {
                if (board[i][j].getSymbol() != PlayerSymbol.EMPTY &&
                        board[i][j].getSymbol() == board[i-1][j+1].getSymbol() &&
                        board[i][j].getSymbol() == board[i-2][j+2].getSymbol()) {
                    return (board[i][j].getSymbol().PlayerSymbolName());
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
