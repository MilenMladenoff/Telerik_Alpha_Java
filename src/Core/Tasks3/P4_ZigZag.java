package Core.Tasks3;

import java.util.Scanner;

public class P4_ZigZag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] matrix = new int[n][m];

        int firstCol = 1;
        matrix[0][0] = 1;

        for (int row = 0; row < n; row++) {
            matrix[row][0] = firstCol;
            int matrixValue = firstCol;

            for (int col = 1; col < m; col++) {
                matrixValue += 3;
                matrix[row][col] = matrixValue;
            }

            firstCol += 3;
        }

        long pathSum = 0;

        pathSum += sumPathWithoutLastCell(n, m, matrix);

        if (n % 2 == 0) {
            pathSum += matrix[n - 1][m - 1];
        } else {
            pathSum += matrix[n - 1][0];
        }

        System.out.println(pathSum);
    }

    private static long sumPathWithoutLastCell(int n, int m, int[][] matrix) {
        long sum = 0;

        for (int i = 0; i < n - 1; i++) {

            if (i % 2 == 0) {

                for (int rightDirection = 0; rightDirection < m - 1; rightDirection++) {

                    if (rightDirection % 2 == 0) {
                        sum += matrix[i][rightDirection];
                    } else {
                        sum += matrix[i + 1][rightDirection];
                    }
                }

            } else {

                for (int leftDirection = m - 1; leftDirection > 0; leftDirection--) {

                    if (leftDirection % 2 != 0) {
                        sum += matrix[i][leftDirection];
                    } else {
                        sum += matrix[i + 1][leftDirection];
                    }
                }

            }
        }

        return sum;
    }
}
