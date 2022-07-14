package Core.Tasks2;

import java.util.Scanner;

public class P1_PrimeTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= i - 1; j++) {

                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {

                for (int j = 1; j <= i; j++) {
                    boolean isOne = true;

                    for (int k = 2; k <= j - 1; k++) {

                        if (j % k == 0) {
                            isOne = false;
                            break;
                        }
                    }

                    if (isOne) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }

                System.out.println();
            }
        }
    }
}
