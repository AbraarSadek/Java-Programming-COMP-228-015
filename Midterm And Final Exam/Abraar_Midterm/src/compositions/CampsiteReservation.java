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

//CampsiteReservation Class
public class CampsiteReservation extends ProvincialPark {

    //CampsiteReservation Class Properties
    public int groupSize;
    public int requestedNumberOfSites;
    public int numberOfDays;

    //Empty Constructor
    public CampsiteReservation() {
        this.groupSize = 0;
        this.requestedNumberOfSites = 0;
        this.numberOfDays = 0;
    } //End of Empty Constructor

    //CampsiteReservation Class Initialized Constructor - With the parameters of "groupSize", "requestedNumberOfSites" & "numberOfDays"
    public CampsiteReservation(int groupSize, int requestedNumberOfSites, int numberOfDays) {

        //If Statement - That will check if enough number of sites are available and if user is not requesting more than 3 sites
        if (requestedNumberOfSites >= availableSites && requestedNumberOfSites == groupSize * 6 && requestedNumberOfSites <= 3 && numberOfDays <= 6) {
            //Initialize
            this.groupSize = groupSize;
            this.requestedNumberOfSites = requestedNumberOfSites;
            this.numberOfDays = numberOfDays;
            System.out.println("Your Reservation Can Not Be Made, See You Soon" + "\n");
            System.out.println("Number of Available Sites: " + availableSites);
        } else {
            //Initialize to 0
            this.groupSize = 0;
            this.requestedNumberOfSites = 0;
            this.numberOfDays = 0;
            System.out.println("Unfortunately Your Reservation Can Not Be Made" + "\n");
        } //End of If Statement

    } //End of CampsiteReservation Class Initialized Constructor

    //Overridden getReservationCost Method
    @Override
    public double getReservationCost() {

        //If Statement - To Check and Set reservationCost Variable Value
        if (numberOfDays > 3) {
            super.reservationCost = 45 * numberOfDays;
        } else {
            super.reservationCost = 40 * numberOfDays;
        } //End of If Statement

        return super.reservationCost; //Return

    } //End of Overridden getReservationCost Method

    //toString Method
    @Override
    public String toString() {
        return "CampsiteReservation: " +
                "\nProvincial Park Address: " + address +
                "\nProvincial Park Currently Available Number of Sites: " + availableSites +
                "\nGroup Size: " + groupSize +
                "\nRequested Number of Sites: " + requestedNumberOfSites +
                "\n Number of Days: " + numberOfDays +
                "\n Reservation Cost: " + this.getReservationCost() + "\n";
    } //End of toString Method

} //End of CampsiteReservation Class
