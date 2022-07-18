package Core.Tasks3;

import java.util.Scanner;

public class P5_SpiralMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][n];
        int matrixValue = 0;
        int lineCounter = n;

        for (int i = 0; i <= n / 2; i++) {

            for (int j = i; j < lineCounter; j++) {
                matrixValue++;
                matrix[i][j] = matrixValue;
            }

            for (int j = i + 1; j < lineCounter; j++) {
                matrixValue++;
                matrix[j][lineCounter - 1] = matrixValue;
            }

            for (int j = lineCounter - 2; j >= i; j--) {
                matrixValue++;
                matrix[lineCounter - 1][j] = matrixValue;
            }

            for (int j = lineCounter - 2; j > i; j--) {
                matrixValue++;
                matrix[j][i] = matrixValue;
            }

            lineCounter--;
        }

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}
