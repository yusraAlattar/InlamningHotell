package com.company;

public class SingleRoom extends Room {

   protected float price = 100.95f;
    /**
     * This will print out information about this specific
     * room and the different advanteges from the enum list
     * will be printed out.
     */
    public SingleRoom() {
        roomPrice = 100.95f;
        info = " single room ";

    }
    @Override
    public void showInfo() {
        System.out.println("Single room Check-in time: 12:00, check-out time 12:00");


    roomAdvantages = new roomOptions[]{

                roomOptions.TV,
                roomOptions.Internet,
                roomOptions.Aircondition,
                roomOptions.SharedBathroom


        };


        }

    }
