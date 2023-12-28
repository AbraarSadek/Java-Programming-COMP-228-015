/*
    Student Number: XXXXXXXXX
    Student Name: Abraar Sadek
    Course: COMP228
    Section: 015
    Username: Abraar
    File Creation Date: 9/16/2023
*/

// Singers Class
public class Singers {

    //Instance Variables:
    private int singerID; //Int variable that will hold the four-digit ID for the signers
    public String singerName; //String variable that will hold the singers full name
    private String singerAddress; //String variable that will hold the singers address
    public String dateOfBirth; //String variable that will hold the singers date of birth
    public int numberOfAlbumsPublished; //Int variable that will hold the number of albums the singer has published

    //Constructors:

    //Singers Constructor(1) - Initializes properties of "Singers" class with placeholders
    public Singers() {
        this.singerID = 0;
        this.singerName = "First Name Last Name";
        this.singerAddress = "00 [Street Name] [City], [Province (ON, BC, etc...)] [Postal Code]";
        this.dateOfBirth = "00/00/0000";
        this.numberOfAlbumsPublished = 0;
    } //End of Singers Constructor(1)

    //Singers Constructor(2) - With the parameter of "singerID"
    public Singers(int singerID) {
        this.singerID = singerID;
        this.singerName = "First Name Last Name";
        this.singerAddress = "00 [Street Name] [City], [Province (ON, BC, etc...)] [Postal Code]";
        this.dateOfBirth = "00/00/0000";
        this.numberOfAlbumsPublished = 0;
    }// End of Singers Constructor(2)

    //Singers Constructor(3) - With the parameters of "singerID" & "singerName"
    public Singers(int singerID, String singerName) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = "00 [Street Name] [City], [Province (ON, BC, etc...)] [Postal Code]";
        this.dateOfBirth = "00/00/0000";
        this.numberOfAlbumsPublished = 0;
    }// End of Singers Constructor(3)

    //Singers Constructor(4) - With the parameters of "singerID", "singerName" & "singerAddress"
    public Singers(int singerID, String singerName, String singerAddress) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = "00/00/0000";
        this.numberOfAlbumsPublished = 0;
    }// End of Singers Constructor(4)

    //Singers Constructor(5) - With the parameters of "singerID", "singerName", "singerAddress" & "dateOfBirth"
    public Singers(int singerID, String singerName, String singerAddress, String dateOfBirth) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = 0;
    }// End of Singers Constructor(5)

    //Singers Constructor(6) - With the parameters of "singerID", "singerName", "singerAddress", "dateOfBirth" & "numberOfAlbumsPublished"
    public Singers(int singerID, String singerName, String singerAddress, String dateOfBirth, int numberOfAlbumsPublished) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }// End of Singers Constructor(6)

    //Getters & Setters:

    //Getter & Setters for variable "singerID"
    public int getSingerID() {
        return this.singerID;
    }
    public void setSingerID(int singerID) {
        this.singerID = singerID;
    }//End of Getter & Setters for variable "singerID"

    //Getter & Setters for variable "singerName"
    public String getSingerName() {
        return this.singerName;
    }
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }//End of Getter & Setters for variable "singerName"

    //Getter & Setters for variable "singerAddress"
    public String getSingerAddress() {
        return this.singerAddress;
    }
    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress;
    }//End of Getter & Setters for variable "singerAddress"

    //Getter & Setters for variable "dateOfBirth"
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }//End of Getter & Setters for variable "dateOfBirth"

    //Getter & Setters for variable "numberOfAlbumsPublished"
    public int getNumberOfAlbumsPublished() {
        return this.numberOfAlbumsPublished;
    }
    public void setNumberOfAlbumsPublished(int numberOfAlbumsPublished) {
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }//End of Getter & Setters for variable "numberOfAlbumsPublished"

    //Setter that will set all Instance Variables
    public void setAllInstanceVariables(int singerID, String singerName, String singerAddress, String dateOfBirth, int numberOfAlbumsPublished) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }//End of Setter that will set all Instance Variables

    //toString Method
    @Override //Modifying the default toString method
    public String toString() {
        return  "\n Singers ID: " + this.singerID +
                "\n Singers Name: " + this.singerName +
                "\n Singers Address: " + this.singerAddress +
                "\n Singers Birth Day: " + this.dateOfBirth +
                "\n Number of Albums Singer Has Published: " + this.numberOfAlbumsPublished + "\n";
    }//End of toString Method

}// End of Singers Class
