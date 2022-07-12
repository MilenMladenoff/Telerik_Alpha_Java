package Core.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_ReverseArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbers);

        for (int i = 0; i < numbers.size(); i++) {

            if (i == numbers.size() - 1) {
                System.out.print(numbers.get(i));
            } else {
                System.out.printf("%d, ", numbers.get(i));
            }
        }
    }
}
