package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Person implements Serializable {
    private static final long serialVersionUID = -6849794474667710L;
    private String name;
    private String phone;
    private int roomChoice;
    String date = new Date().toString();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoomChoice() {
        return roomChoice;
    }

    public void setRoomChoice(int roomChoice) {
        this.roomChoice = roomChoice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    private int numberOfNights;

    public Person(String name, String phone, int roomChoice, int numberOfNights) {
        this.name = name;
        this.phone = phone;
        this.roomChoice = roomChoice;
        this.numberOfNights = numberOfNights;

    }


    }
