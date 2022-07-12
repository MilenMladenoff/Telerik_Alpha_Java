package Core.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P5_ThreeGroups {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> remainder0 = new ArrayList<>();
        List<Integer> remainder1 = new ArrayList<>();
        List<Integer> remainder2 = new ArrayList<>();

        for (int number : inputArr) {

            if (number % 3 == 0) {
                remainder0.add(number);
            } else if (number % 3 == 1) {
                remainder1.add(number);
            } else {
                remainder2.add(number);
            }
        }

        System.out.println(remainder0.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(remainder1.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(remainder2.toString().replaceAll("[\\[\\],]", ""));
    }
}
