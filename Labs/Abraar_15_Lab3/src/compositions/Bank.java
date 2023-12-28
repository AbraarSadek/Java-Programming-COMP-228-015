package compositions;
import java.util.ArrayList;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/23/2023
 */

//Bank Class
public class Bank {

    //Bank Class Properties
    public static ArrayList<Account> accountList;

    //Static Block
    static {
        accountList = new ArrayList<>();
        accountList.add(new SavingsAccount("S101", "James Finch", 222210212, 3400.90F));
        accountList.add(new SavingsAccount("S102", "Kell Forest", 222214500, 42520.32F));
        accountList.add(new SavingsAccount("S103", "Amy Stone", 222212000, 8273.45F));
        accountList.add(new ChequingAccount("C104", "Kaitlin Ross", 333315002, 91230.45F));
        accountList.add(new ChequingAccount("C105", "Adem First", 333303019, 43987.67F));
        accountList.add(new ChequingAccount("C106", "John Doe", 333358927, 34829.76F));
    } //End of Static Block

    //toString
    @Override
    public String toString() {
        String returnStatment = ""; //Empty String

        //For Each Loop - To iterate through "accountList" array list
        for (Account account : accountList) {
            returnStatment += account; //Concatenate
        } //End of For Each Loop

        return returnStatment; //return
    } //End of toString Method

} //End of Bank Class
