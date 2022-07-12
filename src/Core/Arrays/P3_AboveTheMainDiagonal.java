package Core.Arrays;

import java.util.Scanner;

public class P3_AboveTheMainDiagonal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        long[] powersOf2 = new long[n * 2];
        powersOf2[0] = 1;

        if (n > 1) {
            powersOf2[1] = 2;

            for (int i = 2; i < n * 2; i++) {
                powersOf2[i] = powersOf2[i - 1] * 2;
            }
        }

        long sum = 0;
        int verticalPosition = 1;

        for (int rows = 1; rows < n; rows++) {
            int horizontalPosition = verticalPosition;

            for (int cols = rows + 1; cols <= n; cols++) {
                sum += powersOf2[horizontalPosition];
                horizontalPosition++;
            }

            verticalPosition += 2;
        }

        System.out.println(sum);
    }
}
