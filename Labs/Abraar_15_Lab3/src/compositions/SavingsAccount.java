package compositions;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/21/2023
 */

//SavingsAccount Class
public class SavingsAccount extends Account {

    //SavingsAccount Class Properties
    private float balance;

    //Default SavingsAccount Constructor
    public SavingsAccount() {
        this.balance = 0;
    } //End of Default SavingsAccount Constructor

    //Parameterized SavingsAccount Constructor
    public SavingsAccount(String id, String name, int accountNum, float balance) {
        super(id, name, accountNum);
        this.balance = balance;
    } //End of Parameterized SavingsAccount Constructor

    //SavingsAccount Class Properties Getters & Setters
    public float getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }
    //End of SavingsAccount Class Properties Getters & Setters

    //Overridden Withdraw Method
    @Override
    public void Withdraw(float amount) {
        //If Statement - To Check If The Amount Being Requested For Withdrawal Is Not More Than The Value of Balance Variable
        if (balance < amount) {
            System.out.println("Withdrawal Request Denied!" +
                    "\nInsufficient Balance: $" + balance +
                    "\nIn Savings Account: " + accountNum + ", Unable To Proceed With The Withdrawal Request Of Amount: $" + amount + "\n"); //Print To Screen
        } else if (balance - amount <= 3000) { //Else If - To Check If After The Amount Is Deducted From Balance Variable, That It Is Not Less Then 3000
            System.out.println("Withdrawal Request Denied!" +
                    "\nInsufficient Balance: $" + balance +
                    "\nFor Withdrawal Request Of: " + amount + ", Which Will Leave Your Savings Account: " + accountNum + ", With Less Then $3000." +
                    "\nWhich Is Less Then Necessary Required Balance Of $3000, As Stated In Your Contract." + "\n"); //Print To Screen
        } else { //Else - Process the Withdrawal, Alert The User & Output Remaining Balance In Users Account
            System.out.println("Withdrawal Request Accepted!" +
                    "\nAmount: $" + amount + ", Withdrawn Successfully From: $" + balance + ", From Your Savings Account: " + accountNum + "." +
                    "\nYour Remaining Balance In Your Savings Account Is: " + (balance - amount) + "\n"); //Print To Screen

        } //End of If Statement
    } //End of Overridden Withdraw Method

    //Overridden Deposit Method
    @Override
    public void Deposit(float amount) {
        //If Statement - To Check If The Amount Trying To Be Deposited Into The Account Is Not 0 or Less
        if (amount <= 0) {
            System.out.println("Deposit Request Denied!" +
                    "\nInvalid Deposit Amount: " + amount + ", For Savings Account: " + accountNum + "." +
                    "\nPlease Try Again." + "\n"); //Print To Screen
        } else { //Else - Process the Deposit, Alert The User & Output The New Balance In Users Account
            balance += amount;
            System.out.println("Deposit Request Accepted!" +
                    "\nAmount: $" + amount + " Added To Balance: $" + balance + ", And Deposited Successfully Into Savings Account: " + accountNum + "." +
                    "\nYour Updated Balance Chequing Account Is Now: " + (balance + amount) + "\n"); //Print To Screen
        } //End of If Statement
    } //End of Overridden Deposit Method

    //toString Method
    @Override
    public String toString() {
        return "Savings Account: " +
                "\nConsumer ID: " + super.getId() +
                "\nConsumer Name: " + super.getName() +
                "\nConsumer Savings Account Number: " + accountNum +
                "\nConsumer Savings Account Balance: " + balance + "\n";
    } //End of toString Method

} //End of SavingsAccount Class
