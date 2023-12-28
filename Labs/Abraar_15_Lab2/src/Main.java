import compositions.Dealership;
import compositions.Car;
import enumerations.CarType;


/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 9/30/2023
 */

//Main Class
public class Main {

    //Main Method
    public static void main(String[] args) {
        testCars(); //Call Method "testCars()"
    } //End of Main Method

    //testCars Method
    public static void testCars() {

        System.out.println("\n" + "---------- COMP 228, Section 015 - Java Programming - Lab Two - Abraar Sadek ----------" + "\n"); //Print to screen

        //Create first "Dealership" object and initialize its variables
        Dealership dealershipOne = new Dealership("Quality Cars", "1900 Victoria Park Ave, Toronto", "D01_001");

        //Create two new "Car" objects, initialize the variables and store them into the "carList" array list and then the "dealershipTwo" object
        dealershipOne.addCar("BMW", 2010, "Acura", 31599.99, CarType.SEDAN); //dealershipOne new car one
        dealershipOne.addCar("BMW", 2010, "4 Series", 18998.99, CarType.SUV); //dealershipOne new car two
        dealershipOne.addCar("Honda", 2017, "Accord", 12050.89, CarType.SUV); //dealershipOne new car three

        //Show first "Dealership" object "dealershipOne"
        //System.out.println("DealershipOne: " + dealershipOne); //Print to screen

        System.out.println("Call showCars() method(s) for Dealership object 'dealershipTwo': " + "\n"); //Print to screen

        System.out.println("showCars() Method Call One for Dealership object 'dealershipOne': " + "\n"); //Print to screen
        dealershipOne.showCars("Honda");
        System.out.println("showCars() Method Call Two for Dealership object 'dealershipOne': " + "\n"); //Print to screen
        dealershipOne.showCars("BMW", 2010);
        System.out.println("showCars() Method Call Three for Dealership object 'dealershipOne': " + "\n"); //Print to screen
        dealershipOne.showCars("BMW", 2010, 20000.00);

        //Create second "Dealership" object and initialize its variables
        Dealership dealershipTwo = new Dealership("Easy Cars", "Cleveland St, Toronto, ON M4S 2W4", "D02_002");

        //Create three "Car" objects, initialize the variables and store them into the "carList" array list and then the "dealershipTwo" object
        dealershipTwo.addCar("Tesla", 2019, "Model Y", 70999.99, CarType.HATCHBACK); //dealershipOne new car one
        dealershipTwo.addCar("Tesla", 2019, "Model Y", 65999.99, CarType.HATCHBACK); //dealershipOne new car two
        dealershipTwo.addCar("Mercedes-Benz", 2023, "Sprinter", 80000.00, CarType.TRUCK); //dealershipOne new car three

        //Show first "Dealership" object "dealershipTwo"
        //System.out.println("DealershipTwo: " + dealershipTwo); //Print to screen

        System.out.println("Call showCars() method(s) for Dealership object 'dealershipOne': " + "\n"); //Print to screen

        System.out.println("showCars() Method Call One for Dealership object 'dealershipTwo': " + "\n"); //Print to screen
        dealershipTwo.showCars("Tesla");
        System.out.println("showCars() Method Call Two for Dealership object 'dealershipTwo': " + "\n"); //Print to screen
        dealershipTwo.showCars("Tesla", 2020);
        System.out.println("showCars() Method Call Three for Dealership object 'dealershipTwo': " + "\n"); //Print to screen
        dealershipTwo.showCars("Mercedes-Benz", 2023, 80000.00);

    } //End of testCars Method

} //End of Main Class