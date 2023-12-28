//Import Classes From compositions
import compositions.Bank;
import compositions.Consumer;
import compositions.Account;
import compositions.SavingsAccount;
import compositions.ChequingAccount;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/21/2023
 */

//Main Class
public class Main {

    //Main Method
    public static void main(String[] args) {

        //Call Method
        BankTest();

    } //End of Main Method

    //BankTest Method
    public static void BankTest() {

        System.out.println("\n" + "---------- COMP 228, Section 015 - Java Programming - Lab Three - Abraar Sadek ----------" + "\n"); //Print to screen

        //Create first "Bank" object and test it using "accountList" arraylist Property
        Bank bankOne = new Bank();

        System.out.println("---------- Bank Object One TEST ----------"); //Print to Screen

        //Withdraw specific amounts into different accounts within bankOne's accountList
        bankOne.accountList.get(0).Withdraw(5000F);
        bankOne.accountList.get(1).Withdraw(40000F);
        bankOne.accountList.get(2).Withdraw(2000F);
        bankOne.accountList.get(3).Withdraw(95000F);
        bankOne.accountList.get(4).Withdraw(25000F);
        bankOne.accountList.get(5).Withdraw(30000F);

        //Create first "Bank" object and test it using "accountList" arraylist Property
        Bank bankTwo = new Bank();

        System.out.println("---------- Bank Object Two TEST ----------"); //Print to Screen

        //Deposit specific amounts into different accounts within bankTwo's accountList
        bankTwo.accountList.get(0).Deposit(0F);
        bankTwo.accountList.get(1).Deposit(1000F);
        bankTwo.accountList.get(2).Deposit(15000F);
        bankTwo.accountList.get(3).Deposit(-100F);
        bankTwo.accountList.get(4).Deposit(250F);
        bankTwo.accountList.get(5).Deposit(0.85F);

    } //End of BankTest Method

} //End of Main Class