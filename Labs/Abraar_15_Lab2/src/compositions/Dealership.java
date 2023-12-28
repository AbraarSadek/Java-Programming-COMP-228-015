package compositions;
import enumerations.CarType;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 9/30/2023
 */

//Dealership Class
public class Dealership {

    //Dealership Class Instance Variables
    public String name; //String variable, used to store name of the dealership
    public String address; //String variable, used to store the address of dealership
    private String id; //String variable, used to store ID of each dealership
    private ArrayList<Car> carList; //Array list variable used to store the list of car objects that dealership has in stock

    //Dealership Constructor
    public Dealership(String name, String address, String id) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.carList = new ArrayList<>(); //this.carList = carList;
    } //End of Dealership Constructor

    //Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getId() { return id; }
    public ArrayList<Car> getCarList() { return carList; }
    //End of Getters

    //addCar Method - a method that will display all the cars that have the manufacturer
    public void addCar(String manufacturer, int make, String model, double basePrice, CarType type) {
        this.carList.add(new Car(manufacturer, make, model, basePrice, type)); //Create new object for class "Car"
    } //End of addCar Method

    //showCars Method(1) - a method that will display all the cars that have the same manufacturer
    public void showCars(String manufacturer) {
        boolean found = false; //Boolean variable holding the value of false, and will be used to check if the criteria is met
        //FOR EACH LOOP - to iterate through the "carList" array list
        for (Car car : this.carList) {
            //IF STATEMENT - to check and output car object that have the same manufacturer
            if (Objects.equals(car.getManufacturer(), manufacturer)) {
                found = true; //Update value of boolean variable "found" to "true"
                System.out.println("Manufacturer: " + car.getManufacturer() + "\nMake: " + car.getMake() + "\nModel: " + car.getModel() +
                        "\nVIN Number: " + car.getVIN() + "\nBase Price: " + car.getBasePrice() + "\nCar Type: " + car.getType() + "\n"); //Print to screen
            } //End of first IF STATEMENT
        } //End of FOR EACH LOOP
        //IF STATEMENT - in the case that boolean variable still holds the value of "false"
        if (!found) {
            System.out.println("A car from the manufacturer " + manufacturer + " does not exist." + "\n");
        } //End of second IF STATEMENT
    } //End of showCars Method(1)

    //showCars Method(2) - a method that will display all the cars that have the same manufacturer and make
    public void showCars(String manufacturer, int make) {
        boolean found = false; //Boolean variable holding the value of false, and will be used to check if the criteria is met
        //FOR EACH LOOP - to iterate through the "carList" array list
        for (Car car : this.carList) {
            //IF STATEMENT - to check and output car object that have the same manufacturer and make
            if (Objects.equals(car.getManufacturer(), manufacturer) && car.getMake() == make) {
                found = true; //Update value of boolean variable "found" to "true"
                System.out.println("Car Manufacturer: " + car.getManufacturer() + "\nCar Make: " + car.getMake() + "\nCar Model: " + car.getModel() +
                        "\nCar VIN Number: " + car.getVIN() + "\nCar Base Price: " + car.getBasePrice() + "\nCar Type: " + car.getType() + "\n"); //Print to screen
            }  //End of first IF STATEMENT
        } //End of FOR EACH LOOP
        //IF STATEMENT - in the case that boolean variable still holds the value of "false"
        if (!found) {
            System.out.println("A car from the manufacturer " + manufacturer + " and make year " + make + " does not exist." + "\n");
        } //End of second IF STATEMENT
    } //End of showCars Method(2)

    //showCars Method(3) - a method will display all the cars that have the same manufacturer and make
                           //as well as a basePrice that is NOT more than the given parameter value
    public void showCars(String manufacturer, int make, double basePrice) {
        boolean found = false; //Boolean variable holding the value of false, and will be used to check if the criteria is met
        //FOR EACH LOOP - to iterate through the "carList" array list
        for (Car car : this.carList) {
            //IF STATEMENT - to check and output the car object that have the same manufacturer, make and a base price less than the given parameter value
            if (Objects.equals(car.getManufacturer(), manufacturer) && car.getMake() == make && car.getBasePrice() <= basePrice) {
                found = true; //Update value of boolean variable "found" to "true"
                System.out.println("Manufacturer: " + car.getManufacturer() + "\nMake: " + car.getMake() + "\nModel: " + car.getModel() +
                        "\nVIN Number: " + car.getVIN() + "\nBase Price: " + car.getBasePrice() + "\nCar Type: " + car.getType() + "\n"); //Print to screen
            } //End of first IF STATEMENT
        } //End of FOR EACH LOOP
        //IF STATEMENT - in the case that boolean variable still holds the value of "false"
        if (!found) {
            System.out.println("A car from the manufacturer " + manufacturer + ", make year " + make + " and base price " + basePrice + " does not exist." + "\n");
        } //End of second IF STATEMENT
    } //End of showCars Method(3)

    @Override
    public String toString() {
        //String variable holding the output string for the "DealerShip" class variables
        String dealershipOutput = "\n" + "Dealer Ship Name: " + name + "\n" + "Dealer Ship Address: " + address + "\n" +
                                    "Dealer Ship ID: " + id + "\n\n" + "Cars Available At This Dealer Ship: ";
        //FOR LOOP - to iterate through the "Car" array list and concatenate it to the "dealershipOutput" output variable
        for (Car car : this.carList) {
            dealershipOutput += "\nCar Manufacturer: " + car.getManufacturer() + "\nCar Make: " + car.getMake() + "\nCar Model: " + car.getModel() +
                                    "\nCar VIN Number: " + car.getVIN() + "\nCar Base Price: " + car.getBasePrice() + "\nCar Type: " + car.getType() + "\n";
        } //End of FOR LOOP
        return dealershipOutput; //return
    } //End of toString Method

} //End of Dealership Class
