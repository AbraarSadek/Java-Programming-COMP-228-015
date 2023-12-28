package compositions;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/21/2023
 */

//Account Class
public abstract class Account extends Consumer {

    //Account Class Properties
    protected int accountNum;

    //Default Account Constructor
    public Account() {
        this.accountNum = 0;
    } //End of Default Account Constructor

    //Parameterized Account Constructor
    public Account(String id, String name, int accountNum) {
        super(id, name);
        this.accountNum = accountNum;
    } //End of Parameterized Account Constructor

    //Account Class Properties Getters & Setters
    public int getAccountNum() { return accountNum; }
    public void setAccountNum(int accountNum) { this.accountNum = accountNum; }
    //End of Account Class Properties Getters & Setters

    //Abstract Withdraw Method
    public abstract void Withdraw(float amount);
    //Abstract Deposit Method
    public abstract void Deposit(float amount);

    //toString Method
    @Override
    public String toString() {
        return "Account: " +
                "\nAccount Owner ID: " + super.getId() +
                "\nAccount Owner Name: " + super.getName() +
                "\nAccount Number: " + accountNum + "\n";
    } //End of toString Method

} //End of Account Class
