package Core.Tasks3;

import java.util.Scanner;

public class P1_LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] array = new int[n];
        int maxIncreasingSequence = 1;
        int increasingSequenceCounter = 1;

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scan.nextLine());

            if (i > 0) {

                if (array[i] > array[i - 1]) {
                    increasingSequenceCounter++;

                    if (increasingSequenceCounter > maxIncreasingSequence) {
                        maxIncreasingSequence = increasingSequenceCounter;
                    }

                } else {
                    increasingSequenceCounter = 1;
                }
            }
        }

        System.out.println(maxIncreasingSequence);
    }
}