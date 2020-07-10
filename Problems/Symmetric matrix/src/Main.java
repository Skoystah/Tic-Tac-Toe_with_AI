import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int matrixSize;

        Scanner ipt = new Scanner(System.in);
        matrixSize = ipt.nextInt();

        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrix(matrixSize, ipt, matrix);

        System.out.println(isSymmetric(matrixSize, matrix) ? "YES" : "NO");

    }

    public static void fillMatrix(int matrixSize, Scanner ipt, int[][] matrix) {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = ipt.nextInt();
            }
        }
    }

    public static boolean isSymmetric(int matrixSize, int[][] matrix) {

        for (int k = 1; k < matrixSize; k++) {
            for (int l = 1; l <= k; l++) {
                if (matrix[k][k - l] != matrix[k - l][k]) {
                    return false;
                }
            }
        }

        return true;

    }
}