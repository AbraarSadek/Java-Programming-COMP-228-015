/*
    Student Number: XXXXXXXXX
    Student Name: Abraar Sadek
    Course: COMP228
    Section: 015
    Username: Abraar
    File Creation Date: 9/16/2023
*/

//Class Main
public class Main {

    //Main Method
    public static void main(String[] args) {

        System.out.println("TEST! \n"); //Print to screen

        //Call Method
        testSigners();

    } //End of Main Method

    //testSigners Method - Used To Test The Singers Class:
    public static void testSigners(){

        //Print to screen
        System.out.println("------------------- Testing Singers Class -------------------");

        //Creating an object of class "Singers" called "singer1" and initializing it
        Singers singer1 = new Singers();

        //Display the default value of the instance variables of object singer1
        System.out.println("Singer 1 Details (With Default Values): \n" + singer1);

        //Changing the values of each instance variables with the help of setters
        singer1.setSingerID(1000);
        singer1.setSingerName("Michael Bublé");
        singer1.setSingerAddress("50 Carroll St, Toronto, ON M4M 3G3");
        singer1.setDateOfBirth("09/09/1975");
        singer1.setNumberOfAlbumsPublished(14);

        //Display the now changed value of the instance variables of object singer1
        System.out.println("Singer 1 Details (With Updated Values): \n" + singer1);

        //Creating an object of class "Singers" using "Singers Constructor(4)"  called "singer2" with parameters and initializing it
        Singers singer2 = new Singers(2000, "Diana Ross", "20 Dunlace Dr, North York, ON M2L 2S1");

        //Display the values of the instance variables of object singer2
        System.out.println("Singer 2 Details: \n" + singer2);

        //Creating an object of class "Singers" using "Singers Constructor(6)" called "singer3" with parameters and initializing it
        Singers singer3 = new Singers(3000, "Michael Jackson", "147 Danforth Ave, Toronto, ON M4K 1N2", "08/29/1958", 36);

        //Display the values of the instance variables of object singer3
        System.out.println("Singer 3 Details: \n" + singer3);

    } //End of testSigners Method

} //End of Class Main