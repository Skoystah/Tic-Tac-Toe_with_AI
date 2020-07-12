package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Move {

    private int column;
    private int row;
    private Player player;

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Player getPlayer() {
        return player;
    }

    public void playerMove(PlayingField board) {

        Scanner ipt = new Scanner(System.in);
        System.out.println("What's your next move sport?");
        String[] coordinates = ipt.nextLine().split(" ");

        while (!validCoordinates(coordinates, board)) {
            coordinates = ipt.nextLine().split(" ");
        }
    }

    private boolean validCoordinates(String[] coordinates, PlayingField board) {
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

    public void computerMove(PlayingField board) {
        Random rand = new Random();
        this.player = board.getPhasingPlayer();

        do {
            this.column = rand.nextInt(3) + 1;
            this.row = rand.nextInt(3) + 1;
        } while (!board.isEmptySquare(column, row));

        System.out.printf("Making move level \"%s\"%n", player.getDifficulty());

    }
}
