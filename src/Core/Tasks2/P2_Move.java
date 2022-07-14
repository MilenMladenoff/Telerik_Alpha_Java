package Core.Tasks2;

import java.util.Arrays;
import java.util.Scanner;

public class P2_Move {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int position = Integer.parseInt(scan.nextLine());
        int[] arr = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        String inputCommand = scan.nextLine();
        long forwardSum = 0;
        long backwardsSum = 0;

        while (!inputCommand.equals("exit")) {
            String[] command = inputCommand.split(" ");
            int steps = Integer.parseInt(command[0]);
            String direction = command[1];
            int stepSize = Integer.parseInt(command[2]);

            switch (direction) {
                case "forward":

                    for (int i = 1; i <= steps; i++) {

                        for (int j = 1; j <= stepSize; j++) {
                            position++;

                            if (position >= arr.length) {
                                position = 0;
                            }
                        }

                        forwardSum += arr[position];
                    }

                    break;
                case "backwards":

                    for (int i = 1; i <= steps; i++) {

                        for (int j = 1; j <= stepSize; j++) {
                            position--;

                            if (0 > position) {
                                position = arr.length - 1;
                            }
                        }

                        backwardsSum += arr[position];
                    }

                    break;
            }

            inputCommand = scan.nextLine();
        }

        System.out.printf("Forward: %d%n", forwardSum);
        System.out.printf("Backwards: %d", backwardsSum);
    }
}
