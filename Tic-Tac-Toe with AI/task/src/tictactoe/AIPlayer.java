package tictactoe;

public class AIPlayer extends Player {

    private String difficulty;

    public AIPlayer() {}

    public AIPlayer(String difficulty, String type, char symbol) {
        super(type, symbol);
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
