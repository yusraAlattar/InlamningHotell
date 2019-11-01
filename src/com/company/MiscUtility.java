package com.company;

public class MiscUtility {

    public static int getIntegerFromString() {
        String input;
        do {
            input = Main.myScan.nextLine();

            try {
                Integer.parseInt(input);
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);
    }
}
