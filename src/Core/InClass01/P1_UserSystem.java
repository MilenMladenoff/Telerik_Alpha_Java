package Core.InClass01;

import java.util.Scanner;

public class P1_UserSystem {
    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");

            if (commandArgs.length < 3) {
                System.out.println(ANSI_RED + "Too few parameters." + ANSI_RESET);
                command = scanner.nextLine();
                continue;
            }

            String username = commandArgs[1];
            String password = commandArgs[2];

            if (username.length() < 3) {
                System.out.println(ANSI_RED + "Username must be at least 3 characters long." + ANSI_RESET);
                command = scanner.nextLine();
                continue;
            }

            if (password.length() < 3) {
                System.out.println(ANSI_RED + "Password must be at least 3 characters long." + ANSI_RESET);
                command = scanner.nextLine();
                continue;
            }

            if (commandArgs[0].equals("register")) {
                registerAccount(usersData, username, password, ANSI_GREEN, ANSI_RED, ANSI_RESET);
                command = scanner.nextLine();
            } else if (commandArgs[0].equals("delete")) {
                deleteAccount(usersData, username, password, ANSI_GREEN, ANSI_RED, ANSI_RESET);
                command = scanner.nextLine();
            }
        }
    }

    private static void registerAccount(String[][] usersData, String username,
                                        String password, String ANSI_GREEN, String ANSI_RED, String ANSI_RESET) {

        boolean usernameExists = false;
        for (String[] usersDatum : usersData) {
            if (username.equals(usersDatum[0])) {
                usernameExists = true;
                break;
            }
        }

        if (usernameExists) {
            System.out.println(ANSI_RED + "Username already exists." + ANSI_RESET);
        } else {
            int freeSlotIndex = -1;
            for (int i = 0; i < usersData.length; i++) {
                if (usersData[i][0] == null) {
                    freeSlotIndex = i;
                }
            }

            if (freeSlotIndex == -1) {
                System.out.println(ANSI_RED + "The system supports a maximum number of 4 users." + ANSI_RESET);
            } else {
                usersData[freeSlotIndex][0] = username;
                usersData[freeSlotIndex][1] = password;

                System.out.println(ANSI_GREEN + "Registered user." + ANSI_RESET);
            }
        }
    }

    private static void deleteAccount(String[][] usersData, String username,
                                      String password, String ANSI_GREEN, String ANSI_RED, String ANSI_RESET) {

        int accountIndex = -1;
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                accountIndex = i;
            }
        }

        if (accountIndex == -1) {
            System.out.println(ANSI_RED + "Invalid account/password." + ANSI_RESET);
        } else {
            usersData[accountIndex][0] = null;
            usersData[accountIndex][1] = null;

            System.out.println(ANSI_GREEN + "Deleted account." + ANSI_RESET);
        }
    }
}
