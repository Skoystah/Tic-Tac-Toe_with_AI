import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        int matrixSize = 4;
        int squareSize = 2;

        char[][] matrix = new char[matrixSize][matrixSize];


        fillMatrix(matrixSize, matrix);

        System.out.println(isPretty(matrixSize, squareSize, matrix) ? "YES" : "NO");

    }

    public static void fillMatrix(int matrixSize, char[][] matrix) {
        Scanner ipt = new Scanner(System.in);

        for (int i = 0; i < matrixSize; i++) {
            if (ipt.hasNext()) {
                matrix[i] = ipt.nextLine().toCharArray();
            }
        }
    }

    public static boolean isPretty(int matrixSize, int squareSize, char[][] matrix) {
        for (int i = 0; i <= matrixSize - squareSize; i++) {
            for (int j = 0; j <= matrixSize - squareSize; j++) {
                if (isSquare(squareSize, matrix, i, j)) {
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean isSquare(int squareSize, char[][] matrix, int i, int j) {
        char currentElement = matrix[i][j];

        for (int k = i; k < i + squareSize; k++) {
            for (int l = j; l < j + squareSize; l++) {
                if (matrix[k][l] != currentElement) {
                    return false;
                }
            }
        }

        return true;
    }
}