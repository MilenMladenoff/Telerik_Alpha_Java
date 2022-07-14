package Core.Tasks2;

import java.util.Scanner;

public class P4_Bounce {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int matrixRows = scan.nextInt();
        int matrixCols = scan.nextInt();
        long[][] matrix = new long[matrixRows][matrixCols];

        long firstCol = 1;
        matrix[0][0] = 1;

        for (int rows = 0; rows < matrixRows; rows++) {
            matrix[rows][0] = firstCol;
            long matrixValues = firstCol;

            for (int cols = 1; cols < matrixCols; cols++) {
                matrixValues *= 2;
                matrix[rows][cols] = matrixValues;
            }

            firstCol *= 2;
        }

        if (matrixCols == 1 || matrixRows == 1) {
            System.out.println(1);
            return;
        }

        int currentRow = 0;
        int currentCol = 0;
        int horizontalDirection = 1;
        int verticalDirection = 1;
        long sum = 1;

        while (true) {
            currentCol += horizontalDirection;
            currentRow += verticalDirection;

            if (currentRow == matrixRows - 1) {
                verticalDirection *= -1;
            } else if (currentCol == matrixCols - 1) {
                horizontalDirection *= -1;
            } else if (currentRow == 0) {
                verticalDirection *= -1;
            } else if (currentCol == 0) {
                horizontalDirection *= -1;
            }

            sum += matrix[currentRow][currentCol];

            if ((currentCol == 0 && currentRow == 0) || (currentCol == matrixCols - 1 && currentRow == matrixRows - 1)
                    || (currentCol == 0 && currentRow == matrixRows - 1)
                    || (currentCol == matrixCols - 1 && currentRow == 0)) {
                break;
            }
        }

        System.out.println(sum);
    }
}
