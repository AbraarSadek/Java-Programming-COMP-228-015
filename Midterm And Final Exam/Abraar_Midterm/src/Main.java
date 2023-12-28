import compositions.CampsiteReservation;
import compositions.DailyVehiclePermit;
import compositions.ProvincialPark;

import java.util.ArrayList;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/16/2023
 */

//Main Class
public class Main {

    //Main Method
    public static void main(String[] args) {

        //Call Method
        testReservations();

    } //End of Main Method

    //testReservations Method
    public static void testReservations() {
        System.out.println("---------- COMP 228, Section 015 - Java Programming - Midterm - Abraar Sadek ----------" + "\n"); //Print to screen

        //Create New ArrayList Called provincialParkArrayList
        ArrayList<ProvincialPark> provincialParkArrayList = new ArrayList<>();

        //Create CampsiteReservation objects For CampsiteReservation Class
        CampsiteReservation CampsiteReservationOne = new CampsiteReservation(18, 3, 5);
        CampsiteReservation CampsiteReservationTwo = new CampsiteReservation(20, 3, 10);

        //Add CampsiteReservation objects to the ArrayList
        provincialParkArrayList.add(CampsiteReservationOne);
        provincialParkArrayList.add(CampsiteReservationTwo);

        //Create DailyVehiclePermit objects For DailyVehiclePermit Class
        DailyVehiclePermit DailyVehiclePermitOne = new DailyVehiclePermit(2, 4);
        DailyVehiclePermit DailyVehiclePermitTwo = new DailyVehiclePermit(8, 5);

        //Add DailyVehiclePermit objects to the ArrayList
        provincialParkArrayList.add(DailyVehiclePermitOne);
        provincialParkArrayList.add(DailyVehiclePermitTwo);

        //For Each Loop
        for (ProvincialPark ProvincialParkArrayList : provincialParkArrayList) {
            System.out.println("Provincial Park Reservation: " + ProvincialParkArrayList);
        } //End of For Each Loop

    } //End of testReservations Method

} //End of Main Class