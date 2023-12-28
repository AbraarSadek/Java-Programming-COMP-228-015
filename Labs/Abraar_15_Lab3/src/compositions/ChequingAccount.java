package compositions;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/22/2023
 */

//ChequingsAccount Class
public class ChequingAccount extends Account {

    //ChequingAccount Class Properties
    private float balance;

    //Default ChequingAccount Constructor
    public ChequingAccount() {
        this.balance = 0;
    } //End of Default ChequingAccount Constructor

    //Parameterized ChequingAccount Constructor
    public ChequingAccount(String id, String name, int accountNum, float balance) {
        super(id, name, accountNum);
        this.balance = balance;
    } //End of Parameterized ChequingAccount Constructor

    //ChequingAccount Class Properties Getters & Setters
    public float getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }
    //ChequingAccount Class Properties Getters & Setters

    //Overridden Withdraw Method
    @Override
    public void Withdraw(float amount) {
        //If Statement - To Check If The Amount Being Requested For Withdrawal Is Not More Than The Value of 2000 + Balance Variable Value
        if (balance + 2000 < amount) {
            System.out.println("Withdrawal Request Denied!" +
                    "\nInsufficient Balance: $" + balance +
                    "\nIn Chequing Account: " + accountNum + ", Unable To Proceed With The Withdrawal Request Of Amount: $" + amount + "\n"); //Print To Screen
        } else { //Else - Process the Withdrawal, Alert The User & Output Remaining Balance In Users Account
            System.out.println("Withdrawal Request Accepted!" +
                    "\nAmount: $" + amount + ", Withdrawn Successfully From: $" + balance + ", From Your Chequing Account: " + accountNum + "." +
                    "\nYour Remaining Balance In Your Chequing Account Is: " + (balance - amount) + "\n"); //Print To Screen
        } //End of If Statement
    } //End of Overridden Withdraw Method

    //Overridden Deposit Method
    @Override
    public void Deposit(float amount) {
        //If Statement - To Check If The Amount Trying To Be Deposited Into The Account Is Not 0 or Less
        if (amount <= 0) {
            System.out.println("Deposit Request Denied!" +
                    "\nInvalid Deposit Amount: " + amount + ", For Chequing Account: " + accountNum + "." +
                    "\nPlease Try Again." + "\n"); //Print To Screen
        } else { //Else - Process the Deposit, Alert The User & Output The New Balance In Users Account
            balance += amount;
            System.out.println("Deposit Request Accepted!" +
                    "\nAmount: $" + amount + " Added To Balance: $" + balance + ", And Deposited Successfully Into Chequing Account: " + accountNum + "." +
                    "\nYour Updated Chequing Account Balance Is Now: " + (balance + amount) + "\n"); //Print To Screen
        } //End of If Statement
    } //End of Overridden Deposit Method

    //toString Method
    @Override
    public String toString() {
        return "Chequing Account: " +
                "\nConsumer ID: " + super.getId() +
                "\nConsumer Name: " + super.getName() +
                "\nConsumer Chequing Account Number: " + accountNum +
                "\nConsumer Chequing Account Balance: " + balance + "\n";
    } //End of toString Method

} //End of ChequingsAccount Class
