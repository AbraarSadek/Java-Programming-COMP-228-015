package compositions;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/16/2023
 */

//ProvincialPark Class
public abstract class ProvincialPark {

    //ProvincialPark Class Properties
    public static String address = "Silent Lake Park";
    public static int availableSites = 20;
    protected double reservationCost;
    protected double vehicleReservationCost;

    //abstract getReservationCost Getter
    public abstract double getReservationCost();

    //toString Method
    @Override
    public String toString(){
        return "\nProvincial Park: " +
                "\nProvincial Park Address: " + address +
                "\nProvincial Park Currently Available Number of Sites: " + availableSites + "\n";
    } //End of toString Method

} //End of ProvincialPark Class
