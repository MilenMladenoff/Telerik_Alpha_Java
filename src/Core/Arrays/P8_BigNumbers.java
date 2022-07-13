package Core.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P8_BigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arrSizes = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int arraysLength = Math.max(arrSizes[0], arrSizes[1]);

        String[] token1 = scan.nextLine().split(" ");
        int[] arr1 = fillArrayFromInput(arraysLength, token1);

        String[] token2 = scan.nextLine().split(" ");
        int[] arr2 = fillArrayFromInput(arraysLength, token2);

        int remainder = 0;

        for (int i = 0; i < arraysLength; i++) {

            if (arr1[i] + arr2[i] + remainder <= 9) {
                System.out.print((arr1[i] + arr2[i] + remainder) + " ");
                remainder = 0;
            } else {
                System.out.print((arr1[i] + arr2[i] + remainder - 10) + " ");
                remainder = 1;
            }

        }
    }

    private static int[] fillArrayFromInput(int arraysLength, String[] token1) {
        int[] arr = new int[arraysLength];

        for (int i = 0; i < token1.length; i++) {
            arr[i] = Integer.parseInt(token1[i]);
        }

        return arr;
    }
}
