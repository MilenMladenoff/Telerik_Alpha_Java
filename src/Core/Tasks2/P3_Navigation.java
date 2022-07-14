package Core.Tasks2;

import java.math.BigInteger;
import java.util.Scanner;

public class P3_Navigation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int r = scan.nextInt();
        int c = scan.nextInt();
        int n = scan.nextInt();
        int[] targetCells = new int[n];
        for (int i = 0; i < n; i++) {
            targetCells[i] = scan.nextInt();
        }

        BigInteger[][] matrix = new BigInteger[r][c];
        BigInteger firstRowElement = BigInteger.ONE;
        for (int i = r - 1; i > -1; i--) {
            matrix[i][0] = firstRowElement;
            for (int j = 1; j < c; j++) {
                matrix[i][j] = matrix[i][j - 1].multiply(BigInteger.valueOf(2));
            }
            firstRowElement = firstRowElement.multiply(BigInteger.valueOf(2));
        }

        int coefficient = Math.max(r, c);
        int currentR = r - 1;
        int currentC = 0;
        BigInteger result = BigInteger.ZERO;
        for (int targetCell : targetCells) {
            int targetR = targetCell / coefficient;
            int targetC = targetCell % coefficient;

            int horizontalDirection;
            if (currentC <= targetC) {
                horizontalDirection = 1;
            } else {
                horizontalDirection = -1;
            }

            int verticalDirection;
            if (currentR <= targetR) {
                verticalDirection = 1;
            } else {
                verticalDirection = -1;
            }

            while (currentC != targetC || currentR != targetR) {
                if (!matrix[currentR][currentC].equals(BigInteger.ZERO)) {
                    result = result.add(matrix[currentR][currentC]);
                    matrix[currentR][currentC] = BigInteger.ZERO;
                }

                if (currentC != targetC) {
                    currentC += horizontalDirection;
                    continue;
                }

                currentR += verticalDirection;
            }
        }

        if (!matrix[currentR][currentC].equals(BigInteger.ZERO)) {
            result = result.add(matrix[currentR][currentC]);
            matrix[currentR][currentC] = BigInteger.ZERO;
        }

        System.out.println(result);
    }
}
