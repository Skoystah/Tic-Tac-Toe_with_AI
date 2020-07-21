package tictactoe;

import java.util.HashMap;

public enum PlayerSymbol {
    X (0) {
        @Override
        char PlayerSymbolName() {
            return 'X';
        }
    },
    O (1) {
        @Override
        char PlayerSymbolName() {
            return 'O';
        }
    },
    EMPTY (2) {
        @Override
        char PlayerSymbolName() {
            return ' ';
        }
    };

    private int playerPosition;

    PlayerSymbol(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    private static final HashMap<Integer, PlayerSymbol> lookupSymbol = new HashMap<>();

    static {
        for (PlayerSymbol s : PlayerSymbol.values()) {
            lookupSymbol.put(s.getPlayerPosition(), s);
        }
    }

    private int getPlayerPosition() {
        return playerPosition;
    }

    public static PlayerSymbol lookupSymbolByPosition(int playerPosition) {
        return lookupSymbol.get(playerPosition);
    }

    abstract char PlayerSymbolName();
}
