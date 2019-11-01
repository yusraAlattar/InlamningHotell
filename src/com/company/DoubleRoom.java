package com.company;

public class DoubleRoom extends Room {
protected float price =150.95f;


    public DoubleRoom(){


        roomPrice = 150.95f;
        info = " double room ";
        roomAdvantages = new roomOptions[]{
                roomOptions.TV,
                roomOptions.Internet,
                roomOptions.TwoBeds,
                roomOptions.Bathroom,
                roomOptions.Aircondition,


        };
    }

    @Override
    public void showInfo() {
        System.out.println("Double room Check-in time: 11:00, check-out time: 15:00");
    }
}
                //roomAdvantages = new String[]{"TV", "INTERNET", "Bathroom", "breakfast", "two beds", "Minibar"};


