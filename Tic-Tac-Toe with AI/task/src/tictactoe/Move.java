package tictactoe;

import java.util.Scanner;

public class Move {

    private int column;
    private int row;
    private char player;

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public char getPlayer() {
        return player;
    }

    public void enterMove(PlayingField board) {

        Scanner ipt = new Scanner(System.in);
        System.out.println("What's your next move sport?");
        String[] coordinates = ipt.nextLine().split(" ");
        while (!validateCoordinates(coordinates, board)) {
            coordinates = ipt.nextLine().split(" ");
        }
    }

    private boolean validateCoordinates(String[] coordinates, PlayingField board) {
        // Validate whether coordinates are numeric
        int coordinate;
        for (String c : coordinates) {
            try {
                coordinate = Integer.parseInt(c);
                if (! (coordinate >= 1 && coordinate <= board.getSize())) {
                    System.out.printf("Coordinates should be from 1 to %d!", board.getSize());
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                return false;
            }
        }
        // could probably be refactored
        this.column = Integer.parseInt(coordinates[0]);
        this.row = Integer.parseInt(coordinates[1]);
        this.player = board.getPhasingPlayer();

        if (!board.isEmptySquare(column, row)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }
}
