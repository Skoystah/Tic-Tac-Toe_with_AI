package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public void start() {
        Scanner ipt = new Scanner(System.in);
        Validator validator = new Validator();
        String[] userInput;

        String menuOption;
        String[] players;
        boolean exit = false;

        do {
            System.out.print("What would you like to do: ");
            userInput = ipt.nextLine().split(" ");

            // If input is valid, move to separate variables, else ask user for input again.
            if (validator.validateMenuOption(userInput)) {
                menuOption = userInput[0];
                players = Arrays.copyOfRange(userInput, 1, 3);
            } else {
                continue;
            }

            switch (menuOption) {
                case "start":
                    startGame(players);
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private void startGame(String[] players) {
        Game game = new Game();
        game.startGame(players);
    }


}
