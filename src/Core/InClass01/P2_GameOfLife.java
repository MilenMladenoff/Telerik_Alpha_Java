package Core.InClass01;

import java.util.Arrays;

public class P2_GameOfLife {
    public static void main(String[] args) {
        String input = "000111010";

        // Generation #0
        int generationNumber = 0;
        int[] generation0 = convertToArray(input);
        printGeneration(generation0, generationNumber);

        // Generation #1 Test
        generationNumber++;
        int[] generation1 = getNextGeneration(generation0);
        printGeneration(generation1, generationNumber);
        validateGeneration(generation1, generationNumber, "010111111");

        // Generation #2 Test
        generationNumber++;
        int[] generation2 = getNextGeneration(generation1);
        printGeneration(generation2, generationNumber);
        validateGeneration(generation2, generationNumber, "111000101");

        // Generation #3 Test
        generationNumber++;
        int[] generation3 = getNextGeneration(generation2);
        printGeneration(generation3, generationNumber);
        validateGeneration(generation3, generationNumber, "010101000");

        // Generation #4 Test
        generationNumber++;
        int[] generation4 = getNextGeneration(generation3);
        printGeneration(generation4, generationNumber);
        validateGeneration(generation4, generationNumber, "010010000");

        // Generation #5 Test
        generationNumber++;
        int[] generation5 = getNextGeneration(generation4);
        String generation5Str = convertToString(generation5);
        printGeneration(generation5Str, generationNumber);
        validateGeneration(generation5, generationNumber, "000000000");
    }

    static int[] convertToArray(String str) {
        return Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
    }

    static String convertToString(int[] array) {
        StringBuilder arrayToString = new StringBuilder();

        for (int digit : array) {
            arrayToString.append(digit);
        }

        return arrayToString.toString();
    }

    static int[] convertToArray(int[][] matrix) {
        int[] array = new int[9];
        int index = 0;

        for (int rows = 0; rows < 3; rows++) {

            for (int cols = 0; cols < 3; cols++) {
                array[index] = matrix[rows][cols];
                index++;
            }
        }

        return array;
    }

    static int[][] convertToMatrix(int[] array) {
        int[][] matrix = new int[3][3];
        int position = 0;

        for (int rows = 0; rows < 3; rows++) {

            for (int cols = 0; cols < 3; cols++) {
                matrix[rows][cols] = array[position];
                position++;
            }
        }

        return matrix;
    }

    static void printGeneration(String generation, int generationNumber) {
        System.out.printf("Generation #%d%n", generationNumber);
        int index = 0;

        for (int rows = 0; rows < 3; rows++) {

            for (int cols = 0; cols < 3; cols++) {
                System.out.print(generation.charAt(index) + " ");
                index++;
            }

            System.out.println();
        }
    }

    static void printGeneration(int[] generation, int generationNumber) {
        System.out.printf("Generation #%d%n", generationNumber);
        int position = 0;

        for (int rows = 0; rows < 3; rows++) {

            for (int cols = 0; cols < 3; cols++) {
                System.out.print(generation[position] + " ");
                position++;
            }

            System.out.println();
        }
    }

    static int[] getNextGeneration(int[] generation) {
        int[][] currentGenerationMatrix = convertToMatrix(generation);
        int[][] nextGenerationMatrix = getNextGeneration(currentGenerationMatrix);

        return convertToArray(nextGenerationMatrix);
    }

    static int[][] getNextGeneration(int[][] generation) {
        int[][] nextGeneration = new int[3][3];

        for (int row = 0; row < 3; row++) {

            for (int column = 0; column < 3; column++) {
                nextGeneration[row][column] = applyGameRules(row, column, generation);
            }
        }

        return nextGeneration;
    }

    static int applyGameRules(int row, int column, int[][] generation) {
        int aliveNeighborsCount = getAliveNeighborsCount(row, column, generation);
        int cellStatus = 0;

        if (generation[row][column] == 1 && (aliveNeighborsCount == 2 || aliveNeighborsCount == 3)) {
            cellStatus = 1;
        }

        if (generation[row][column] == 0 && aliveNeighborsCount == 3) {
            cellStatus = 1;
        }

        return cellStatus;
    }

    static int getAliveNeighborsCount(int row, int column, int[][] generation) {
        int aliveNeighborsCounter = 0;

        if (row == 0) {

            if (column == 0) {
                aliveNeighborsCounter += generation[0][1];

                for (int i = 0; i < 2; i++) {
                    aliveNeighborsCounter += generation[row + 1][i];
                }

            } else if (column == generation.length - 1) {
                aliveNeighborsCounter += generation[0][generation.length - 2];

                for (int i = generation.length - 2; i < generation.length; i++) {
                    aliveNeighborsCounter += generation[row + 1][i];
                }

            } else {
                aliveNeighborsCounter += generation[row][column - 1];
                aliveNeighborsCounter += generation[row][column + 1];

                for (int i = column - 1; i <= column + 1; i++) {
                    aliveNeighborsCounter += generation[row + 1][i];
                }
            }
        } else if (row == generation.length - 1) {

            if (column == 0) {

                for (int i = 0; i < 2; i++) {
                    aliveNeighborsCounter += generation[row - 1][i];
                }

                aliveNeighborsCounter += generation[row][1];
            } else if (column == generation[row].length - 1) {

                for (int i = generation[row].length - 2; i < generation[row].length; i++) {
                    aliveNeighborsCounter += generation[row - 1][i];
                }

                aliveNeighborsCounter += generation[row][generation.length - 2];
            } else {

                for (int i = column - 1; i <= column + 1; i++) {
                    aliveNeighborsCounter += generation[row - 1][i];
                }

                aliveNeighborsCounter += generation[row][column - 1];
                aliveNeighborsCounter += generation[row][column + 1];
            }
        } else {

            if (column == 0) {

                for (int i = 0; i < 2; i++) {
                    aliveNeighborsCounter += generation[row - 1][i];
                }

                aliveNeighborsCounter += generation[row][1];

                for (int i = 0; i < 2; i++) {
                    aliveNeighborsCounter += generation[row + 1][i];
                }
            } else if (column == generation.length - 1) {

                for (int i = generation.length - 2; i < generation.length; i++) {
                    aliveNeighborsCounter += generation[row - 1][i];
                }

                aliveNeighborsCounter += generation[row][generation.length - 2];

                for (int i = generation.length - 2; i < generation.length; i++) {
                    aliveNeighborsCounter += generation[row + 1][i];
                }
            } else {

                for (int i = column - 1; i <= column + 1; i++) {
                    aliveNeighborsCounter += generation[0][i];
                }

                aliveNeighborsCounter += generation[row][column - 1];
                aliveNeighborsCounter += generation[row][column + 1];

                for (int i = column - 1; i <= column + 1; i++) {
                    aliveNeighborsCounter += generation[row + 1][i];
                }
            }
        }

        return aliveNeighborsCounter;
    }

    static void validateGeneration(int[] generation, int generationNumber, String expectedGeneration) {
        String generationStr = convertToString(generation);
        String testResult = "PASS";
        if (!generationStr.equals(expectedGeneration)) {
            testResult = "FAIL";
        }
        System.out.printf("Generation #%d Test: %s%n", generationNumber, testResult);
    }
}