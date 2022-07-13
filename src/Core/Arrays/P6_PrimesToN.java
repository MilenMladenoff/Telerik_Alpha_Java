package Core.Arrays;

import java.util.Scanner;

public class P6_PrimesToN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    isPrime = false;
                    break;
                }

            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}
