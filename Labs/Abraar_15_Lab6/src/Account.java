/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 12/1/2023
 */

//Account Class
public class Account {

    //Account Class Properties
    private String ownerName;
    private double balance;

    //Account Class Constructor
    public Account(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 1000.00;
    }
    //End of Account Class Constructor

    //toString Method
    @Override
    public String toString() {
        return "Account Information: " +
                "Account Owners Name: " + ownerName +
                ", Account Balance: " + balance;
    } //End of toString Method

    //performTransaction Method - A synchronized method allows first thread that is called to be sequenced, before moving onto next thread
    public synchronized void performTransaction(TransactionType transactionType, double amount) {

        //Switch Case - To check if value of "transactionType" is either "DEPOSIT" or "WITHDRAW"
        switch (transactionType) {
            case DEPOSIT:
                depositAmount(amount); //Call Method, With Following Parameters
                break;
            case WITHDRAW:
                withdrawAmount(amount); //Call Method, With Following Parameters
                break;
            default:
                System.out.println("[performTransaction Method From Account Class] Invalid Transaction Type");
        } //End of Switch Case

    } //End of performTransaction Method

    //depositAmount Method
    private void depositAmount(double amount) {

        //If Statement - To Check Value of "amount"
        if (amount > 0) {
            balance += amount; //Add "amount" value to "balance"
            System.out.println("[depositAmount Method From Account Class] Successful Deposited $" + amount + " To " + ownerName + " Account. Your New balance Is: $" + balance); //Print to Screen
        } else {
            System.out.println("[depositAmount Method From Account Class] Invalid Deposit Amount, Please Try Again With A Amount That Is Greater Then $0"); //Print to Screen
        } //End of If Statement

    } //End of depositAmount Method

    private void withdrawAmount(double amount) {

        //If Statement - To Check Value of "amount"
        if (amount > 0 && amount <= balance) {
            balance -= amount; //Remove "amount" value from "balance"
            System.out.println("[withdrawAmount Method From Account Class] Successful Withdrew $" + amount + " From " + ownerName + " Account. Your New balance Is: $" + balance); //Print to Screen
        } else {
            System.out.println("[withdrawAmount Method From Account Class] Invalid Withdraw Amount, Please Try Again With A Amount That Is Greater Then $0 And Less Then Or Equal To Your Current Balance: $" + balance); //Print to Screen
        } //End of If Statement

    } //End of withdrawAmount Method

} //End of Account Class
