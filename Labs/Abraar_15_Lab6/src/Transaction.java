/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 12/2/2023
 */

//Transaction Class
public class Transaction implements Runnable{

    //Transaction Class Properties
    private Account account;
    private double amount;
    private TransactionType transactionType;

    //Transaction Class Constructor
    public Transaction(Account account, double amount, TransactionType transactionType) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    } //End of Transaction Class Constructor

    //run Method
    @Override
    public void run() {
        //Call performTransaction() method From Account Class & Pass "transactionType" & "amount" Variables
        account.performTransaction(transactionType, amount);
        System.out.println("[run Method From Transaction Class] Updated Account Details: " + account);
    } //End of run Method

} //End of Transaction Class
