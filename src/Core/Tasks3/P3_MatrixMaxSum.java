package Core.Tasks3;

import java.util.Arrays;
import java.util.Scanner;

public class P3_MatrixMaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int columnsLength = matrix[0].length;

        int[] coordinatesPairs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pairsSums = new int[coordinatesPairs.length / 2];
        int pairsSumsPos = 0;

        for (int i = 0; i < coordinatesPairs.length; i += 2) {
            int r = coordinatesPairs[i];
            int c = coordinatesPairs[i + 1];
            int rowStartPos = Math.abs(r) - 1;
            int colStartPos = 0;

            if (r < 0) {
                colStartPos = columnsLength - 1;
            }

            int rowEndPos = 0;

            if (c < 0) {
                rowEndPos = n - 1;
            }

            int colEndPos = Math.abs(c) - 1;

            int currentPairSum = 0;

            if (colStartPos == 0) {

                for (int horizontalPos = 0; horizontalPos <= colEndPos; horizontalPos++) {
                    currentPairSum += matrix[rowStartPos][horizontalPos];
                }

            } else {

                for (int horizontalPos = columnsLength - 1; horizontalPos >= colEndPos; horizontalPos--) {
                    currentPairSum += matrix[rowStartPos][horizontalPos];
                }
            }

            if (rowEndPos == 0) {

                for (int verticalPos = rowStartPos - 1; verticalPos >= 0; verticalPos--) {
                    currentPairSum += matrix[verticalPos][colEndPos];
                }

            } else {

                for (int verticalPos = rowStartPos + 1; verticalPos < n; verticalPos++) {
                    currentPairSum += matrix[verticalPos][colEndPos];
                }
            }

            pairsSums[pairsSumsPos] = currentPairSum;
            pairsSumsPos++;
        }

        Arrays.sort(pairsSums);
        System.out.println(pairsSums[pairsSums.length - 1]);
    }
}
