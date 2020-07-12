package tictactoe;

public class Validator {

    public boolean validateMenuOption(String[] userInput) {
        switch (userInput[0]) {
            case "start":
                return (validateMenuOptionStart(userInput));
            case "exit":
                return (validateMenuOptionExit(userInput));
            default:
                System.out.print("Unknown command!");
                return false;
        }
    }

    private boolean validateMenuOptionExit(String[] userInput) {
        if (userInput.length != 1) {
            System.out.println("Incorrect amount of parameters!");
            return false;
        }
        return true;
    }

    private boolean validateMenuOptionStart(String[] userInput) {
        if (userInput.length != 3) {
            System.out.println("Incorrect amount of parameters!");
            return false;
        }
        return true;
    }



}
