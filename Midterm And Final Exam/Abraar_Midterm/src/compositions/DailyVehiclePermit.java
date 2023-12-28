package compositions;
import static compositions.ProvincialPark.availableSites;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/16/2023
 */

//DailyVehiclePermit Class
public class DailyVehiclePermit extends CampsiteReservation {

    //DailyVehiclePermit Class Properties
    public int numberOfVehicles;
    public int numberOfHours;

    //DailyVehiclePermit Method
    public DailyVehiclePermit(int numberOfVehicles, int numberOfHours) {

        //If Statement
        if (requestedNumberOfSites <= numberOfVehicles && numberOfVehicles <= 5 && numberOfHours > 3 && numberOfHours < 6) {
            //Initialize
            this.numberOfVehicles = numberOfVehicles;
            this.numberOfHours = numberOfHours;System.out.println("Your Reservation Can Not Be Made, See You Soon" + "\n");
            System.out.println("Number of Available Sites: " + availableSites);
        } else {
            this.numberOfVehicles = 0;
            this.numberOfHours = 0;
            System.out.println("Unfortunately Your Reservation Can Not Be Made" + "\n");
        } //End of If Statement

    } //End of DailyVehiclePermit Method

    //Overridden getReservationCost Method
    @Override
    public double getReservationCost() {
        super.reservationCost = 20 * numberOfVehicles;
        return super.reservationCost;
    } //End of Overridden getReservationCost Method

    //toString Method
    @Override
    public String toString() {
        return "Daily Vehicle Permit: " +
                "\nProvincial Park Address: " + address +
                "\nProvincial Park Currently Available Number of Sites: " + availableSites +
                "\nGroup Size: " + groupSize +
                "\nRequested Number of Sites: " + requestedNumberOfSites +
                "\n Number of Days: " + numberOfDays +
                "\nNumber of Vehicles: " + numberOfVehicles +
                "\nNumber of Hours: " + numberOfHours +
                "\n Reservation Cost: " + this.getReservationCost() + "\n";
    } //End of toString Method

} //End of DailyVehiclePermit Class
