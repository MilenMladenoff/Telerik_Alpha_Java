package Core.Arrays;

import java.util.Scanner;

public class P9_KnightMoves {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] board = new int[n][n];

        int[] horizontalKnightMoves = {-2, -2, -1, -1, +1, +1, +2, +2};
        int[] verticalKnightMoves = {-1, +1, -2, +2, -2, +2, -1, +1};
        int movesCounter = 1;

        for (int rows = 0; rows < n; rows++) {

            for (int cols = 0; cols < n; cols++) {
                int currentRow = rows;
                int currentCol = cols;

                while (board[currentRow][currentCol] == 0) {
                    board[currentRow][currentCol] = movesCounter;
                    movesCounter++;

                    for (int move = 0; move < horizontalKnightMoves.length; move++) {
                        int nextRow = currentRow + horizontalKnightMoves[move];
                        int nextCol = currentCol + verticalKnightMoves[move];

                        if (0 > nextRow || nextRow >= board.length || 0 > nextCol || nextCol >= board.length) {
                            continue;
                        }

                        if (board[nextRow][nextCol] != 0) {
                            continue;
                        }

                        currentRow = nextRow;
                        currentCol = nextCol;
                        break;
                    }
                    
                }
            }
        }

        for (int[] row : board) {
            StringBuilder result = new StringBuilder();

            for (int cell : row) {
                result.append(cell).append(" ");
            }

            System.out.println(result);
        }
    }
}
