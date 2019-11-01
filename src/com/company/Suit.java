package com.company;

public class Suit extends Room {

    public Suit() {
        roomPrice = 200.95f;
        info = " suit ";
        roomAdvantages = new roomOptions[]{
                roomOptions.TV,
                roomOptions.Internet,
                roomOptions.Bathroom,
                roomOptions.Jacuzzi,
                roomOptions.Breakfast,
                roomOptions.KingSizeBed,
                roomOptions.Minibar,
                roomOptions.Computer,
                roomOptions.Aircondition
        };

    }

    @Override
    public void showInfo() {
        System.out.println("Suit Check-in time: 10:00, check-out time: 15:00");
    }
}