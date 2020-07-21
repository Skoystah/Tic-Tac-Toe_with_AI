package tictactoe;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private PlayerSymbol symbol;
    private final String keyword = "user";
    private Move move = new Move();

    public PlayerSymbol getSymbol() {
        return symbol;
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public void assignSymbol(PlayerSymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(PlayingField board) {


        Scanner ipt = new Scanner(System.in);
        System.out.println("What's your next move sport?");
        String[] coordinates;

        do {
            coordinates = ipt.nextLine().split(" ");
        } while (!isValidMove(coordinates, board));

        board.registerMove(move, this);
    }

    //TODO does this belong inside HumanPlayer?
    private boolean isValidMove(String[] coordinates, PlayingField board) {

        int coordinate;
        for (String c : coordinates) {
            try {
                coordinate = Integer.parseInt(c);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                return false;
            }
        }
    //TODO is this the best place to instantiate a new move? should a new move al
        move.enterMove(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        return board.isValidHumanMove(move);
    }
}
