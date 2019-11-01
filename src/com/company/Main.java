package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static Scanner myScan = new Scanner(System.in);

    public static void main(String[] args) {


        MainMeny mainMeny = new MainMeny();
        mainMeny.printHeader();

        mainMeny.getFirstChoice();

        mainMeny.save();


    }
}

