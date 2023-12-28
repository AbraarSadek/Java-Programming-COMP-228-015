package compositions;
import enumerations.CarType;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 9/30/2023
 */

//Car Class
public class Car {

    //Car Class Instance Variables
    public String manufacturer; //String variable, used to store manufacturer name
    public int make; //Int variable, used to store the year the care was made
    public String model; //String variable, used to store the name of the cars model
    private static int VI_NUMBER = 1001; //Int variable, used to create unique Vehicle Identification Number for each car object
    public int VIN = VI_NUMBER; //Int variable, used to represents unique Vehicle Identification Number for each car object, initialized using the value of VI_NUMBER field
    public double basePrice; //Double variable, used to stores the base price of the car
    public CarType type; //CarType variable, used to stores the type of the car

    //Car Constructor
    public Car(String manufacturer, int make, String model, double basePrice, CarType type) {

        //Assign received parameters to the respective class properties
        this.manufacturer = manufacturer;
        this.make = make;
        this.model = model;
        this.basePrice = basePrice;
        VI_NUMBER += 10;
        this.VIN = VI_NUMBER;
        this.type = type;

    } //End of Car Constructor

    //Getters
    public String getManufacturer() { return manufacturer; }
    public int getMake() { return make; }
    public String getModel() { return model; }
    public int getViNumber() { return VIN; }
    public int getVIN() { return VIN; }
    public double getBasePrice() { return basePrice; }
    public CarType getType() { return type; }
    //End of Getters

    //toString Method
    @Override
    public String toString() {

        return "Manufacturer = " + this.manufacturer + "\n" +
                "Car Make = " + this.make + "\n" +
                "Car Model = " + this.model + "\n" +
                "Car VIN = " + this.VIN + "\n" +
                "Base Price of Car = " + this.basePrice + "\n" +
                "Car Type = " + this.type; //return

    } //End of toString Method

} //End of Car Class
