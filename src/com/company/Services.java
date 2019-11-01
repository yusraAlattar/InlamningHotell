

package com.company;


import com.company.FileUtility;
import com.company.Person;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Services {
    public static void readAllLines() {

        String fileName = "person.ser";

        try {

            List<String> lines = Files.readAllLines(Paths.get(fileName));

            for (String line : lines) {

                System.out.println(line);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    //Write some lines to a file
    public static void writeAllLines(String name, String phoneNumber, int roomChoice) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("person.ser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.add(name + "                    " + phoneNumber + "                               " + roomChoice

        );
        try {
            Files.write(Paths.get("person.ser"), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Services.readAllLines();
    }

    public void employeesList() {
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Anna Eriksson");
        employees.add("David Eriksson");
        employees.add("Josef Eriksson");
        System.out.println(employees.toString());

    }
}

