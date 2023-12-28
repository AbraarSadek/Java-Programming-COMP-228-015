import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 12/1/2023
 */

//Main Class
public class Main {

    //Main Method
    public static void main(String[] args) {

        System.out.println("--------------- Abraar Sadek - XXXXXXXXX - Java Programming - COMP 228 - 015 - Lab 6! ---------------" + "\n");

        //Call Method
        TransactionTest();

    } //End of Main Method

    //TransactionTest Method
    static void TransactionTest() {

        Account sharedAccount = new Account("Abraar Sadek");

        //Create Multiple transactions As Threads
        Transaction transactionsOne = new Transaction(sharedAccount, 500, TransactionType.WITHDRAW);
        Transaction transactionsTwo = new Transaction(sharedAccount, 150.25, TransactionType.DEPOSIT);
        Transaction transactionsThree = new Transaction(sharedAccount, 847.92, TransactionType.DEPOSIT);
        Transaction transactionsFour = new Transaction(sharedAccount, 196.75, TransactionType.WITHDRAW);

        //Create An ExecutorService with a fixed pool size
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("Performing Transactions: "); //Print to Screen
        System.out.println("-----------------------------------------------------------------------------------"); //Print to Screen

        //Execute Threads
        executorService.execute(transactionsOne);
        executorService.execute(transactionsTwo);
        executorService.execute(transactionsThree);
        executorService.execute(transactionsFour);

        //Terminate Once All Tasks Are Complete
        executorService.shutdown();

        //Try-Catch Block
        try {
            boolean taskEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException exception) {
            System.out.println("TIME OUT, Waiting For Thread Completion");
        } //End of Try-Catch Block

        System.out.println("Shared Account Details: " + sharedAccount); //Print to Screen

    } //End of TransactionTest Method

} //End of Main Class