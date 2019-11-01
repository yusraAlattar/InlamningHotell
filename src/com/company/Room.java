package com.company;

public abstract class Room {
    public float getRoomPrice() {
        return roomPrice;
    }

    protected float roomPrice;

    protected String info;
public abstract void showInfo();

    /**
     * @author Yusra Alattar
     * This is the enum of the different room advanteges.
     */
    enum roomOptions {
        TV,
        Aircondition,
        Internet,
        Bathroom,
        TwoBeds,
        Breakfast,
        Minibar,
        Computer,
        Jacuzzi,
        SharedBathroom,
        KingSizeBed

    }

    public roomOptions[] roomAdvantages;


    public void printRoomAdvantages() {
        System.out.println("     advantages" + info + "\n");
        for (roomOptions i : roomAdvantages) {
            System.out.println(i);
        }
        System.out.println("Price :" + roomPrice + "$" + " per night");


    }

}