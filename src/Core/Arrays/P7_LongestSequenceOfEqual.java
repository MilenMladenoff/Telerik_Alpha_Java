package Core.Arrays;

import java.util.Scanner;

public class P7_LongestSequenceOfEqual {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scan.nextLine());
        }

        int sequenceCounter = 1;
        int maxSequence = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                sequenceCounter++;

                if (sequenceCounter > maxSequence) {
                    maxSequence = sequenceCounter;
                }

            } else {
                sequenceCounter = 1;
            }

        }

        System.out.println(maxSequence);
    }
}
