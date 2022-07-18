package Core.Tasks3;

import java.util.Scanner;

public class P2_LongestBlockInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int longestBlock = 1;
        char longestBlockSymbol = input.charAt(0);
        int charSequenceCounter = 1;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (i > 0) {

                if (currentChar == input.charAt(i - 1)) {
                    charSequenceCounter++;

                    if (charSequenceCounter > longestBlock) {
                        longestBlock = charSequenceCounter;
                        longestBlockSymbol = currentChar;
                    }

                } else {
                    charSequenceCounter = 1;
                }
            }
        }

        for (int i = 1; i <= longestBlock; i++) {
            System.out.print(longestBlockSymbol);
        }
    }
}
