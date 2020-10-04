package tictactoe;

public class Player {
    private String type;
    private String difficulty;
    private char symbol;

    public Player() {}

    public Player(String player, char symbol) {
        switch (player) {
            //better to use ENUM?
            case "user":
                this.type = "human";
                break;
            case "easy":
                this.type = "ai";
                this.difficulty = "easy";
                break;
        }
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
