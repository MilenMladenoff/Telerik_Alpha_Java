package Core.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P2_SymmetricArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean isSymmetric = true;

            for (int j = 0; j < arr.length / 2; j++) {

                if (arr[j] != arr[arr.length - 1 - j]) {
                    isSymmetric = false;
                    break;
                }
            }

            if (isSymmetric) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
