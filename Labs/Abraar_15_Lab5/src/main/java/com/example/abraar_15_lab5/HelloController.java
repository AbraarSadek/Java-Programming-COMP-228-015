package com.example.abraar_15_lab5;

//Import
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

//HelloController Method
public class HelloController implements Initializable {

    //Class Property's
    @FXML private TextField tfStudentID;
    @FXML private TextField tfTermOneGPA;
    @FXML private TextField tfTermTwoGPA;
    @FXML private TextField tfTermThreeGPA;

    //Temporary Label Property To See Output On scene and console
    @FXML private Label outPut;

    //Property's SQL Connection Property's
    private Connection connection;
    private final String table_name = "LABFIVE_GPA";

    //Property's SQL Insert Property
    private PreparedStatement insertStatement;

    //Property's For Table View
    @FXML private TableView<StudentGrades> tvStudentGrades;
    @FXML private TableColumn<StudentGrades, String> colStudentID;
    @FXML private TableColumn<StudentGrades, Double> colTermOneGPA;
    @FXML private TableColumn<StudentGrades, Double> colTermTwoGPA;
    @FXML private TableColumn<StudentGrades, Double> colTermThreeGPA;
    @FXML private TableColumn<StudentGrades, Double> colCumulativeGPA;

    private ObservableList<StudentGrades> studentGradesList = FXCollections.observableArrayList();

    //initialize Method
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Initialize the table columns
        this.colStudentID = new TableColumn<>("Student ID");
        this.colStudentID.setCellValueFactory(new PropertyValueFactory<StudentGrades, String>("studentID"));
        this.colTermOneGPA = new TableColumn<>("Term One GPA");
        this.colTermOneGPA.setCellValueFactory(new PropertyValueFactory<StudentGrades, Double>("termOneGPA"));
        this.colTermTwoGPA = new TableColumn<>("Term Two GPA");
        this.colTermTwoGPA.setCellValueFactory(new PropertyValueFactory<StudentGrades, Double>("termTwoGPA"));
        this.colTermThreeGPA = new TableColumn<>("Term Three GPA");
        this.colTermThreeGPA.setCellValueFactory(new PropertyValueFactory<StudentGrades, Double>("termThreeGPA"));
        this.colCumulativeGPA = new TableColumn<>("Cumulative GPA");
        this.colCumulativeGPA.setCellValueFactory(new PropertyValueFactory<StudentGrades, Double>("cumulativeGPA"));

        //Set All The Columns To Table View
        this.tvStudentGrades.getColumns().addAll(colStudentID, colTermOneGPA, colTermTwoGPA, colTermThreeGPA, colCumulativeGPA);

        //Connect With Database
        connectToDB(); //Call Method

        //Retrieve existing books from database and display it
        this.showStudentRecords(); //Call Method

    } //End of initialize Method

    //onSaveDataButtonClick Method
    @FXML
    protected void onSaveDataButtonClick() {

        String outputMessage = " "; //String variable to hold Output Message

        //String variables to hold text from text fields
        String studentID = "";
        double termOneGPA = 0.00;
        double termTwoGPA = 0.00;
        double termThreeGPA = 0.00;

        //If Statement - To check if "tfStudentID is empty
        if (tfStudentID.getText().isEmpty()) {
            outputMessage += "\n[onSaveDataButtonClick] Student ID Field Can Not Be Left Empty";
        } else {
            studentID = tfStudentID.getText().toString();
            outputMessage += "\n[onSaveDataButtonClick] The Student's ID Is: " + studentID;
        } //End of If Statement

        //If Statement - To check if "tfTermOneGPA is empty
        if (!this.tfTermOneGPA.getText().toString().isEmpty()) {
            termOneGPA = Double.parseDouble(tfTermOneGPA.getText().toString());
            outputMessage += "\n[onSaveDataButtonClick] The Student's Term One GPA Is: " + termOneGPA;
        } else {
            outputMessage += "\n[onSaveDataButtonClick] Term One GPA Field Can Not Be Left Empty";
        } //End of If Statement

        //If Statement - To check if "tfTermTwoGPA is empty
        if (!this.tfTermTwoGPA.getText().toString().isEmpty()) {
            termTwoGPA = Double.parseDouble(tfTermTwoGPA.getText().toString());
            outputMessage += "\n[onSaveDataButtonClick] The Student's Term Two GPA Is: " + termTwoGPA;
        } else {
            outputMessage += "\n[onSaveDataButtonClick] Term Two GPA Field Can Not Be Left Empty";
        } //End of If Statement

        //If Statement - To check if "tfTermThreeGPA is empty
        if (!this.tfTermThreeGPA.getText().toString().isEmpty()) {
            termThreeGPA = Double.parseDouble(tfTermThreeGPA.getText().toString());
            outputMessage += "\n[onSaveDataButtonClick] The Student's Term Three GPA Is: " + termThreeGPA;
        } else {
            outputMessage += "\n[onSaveDataButtonClick] Term Three GPA Field Can Not Be Left Empty";
        } //End of If Statement

        outPut.setText(outputMessage);
        System.out.println(outputMessage); //Print to screen

        //try-catch Block - To Make Sure That All Fields Have Been Filed Before Inserting Data Into Database
        try {
            insertToDB(studentID, termOneGPA, termTwoGPA, termThreeGPA); //Call Method With Following Parameters
            this.showStudentRecords();
        } catch (Exception exception) {
            System.out.println("\n[onSaveDataButtonClick] Something Went Wrong When Trying To Insert Data Into Database At: " + exception);
            System.out.println("[onSaveDataButtonClick] Please Ensure That All Fields Have Been Field");
        } //End of try-catch Block

    } //End of onSaveDataButtonClick Method

    //connectToDB Method
    void connectToDB() {

        //Replace the below variable values with your own SQL Information

        //Variable's Needed For SQL Connection
        String hostOnCampus = "XXXX:XXXXXX:XXXX:XXXXXXXX.XXXXXXXXXXXXXXXXX.XX:XXXX:XXXX";
        String hostAtHome = "XXXX:XXXXXX:XXXX:XXXX.XXX.XX.XXX:XXXX:XXXX";
        String username = "XXXXXXX_XXX_XX_X";
        String password = "XXXXXXXX";

        //try-catch Block
        try {

            //Register The Driver
            Class.forName("oracle.jdbc.OracleDriver");

            //Create Connection Object
                //To Connect When On Campus
                    connection = DriverManager.getConnection(hostOnCampus, username, password);
                //To Connect When At Home
                    //connection = DriverManager.getConnection(hostAtHome, username, password);

            System.out.println("[connectToDB Method] Connection Established Successfully To Database!!!"); //Print to screen

            //Initialize & Prepare The Insert PreparedStatement Statement
            insertStatement = connection.prepareStatement("INSERT INTO " + table_name + " VALUES(?, ?, ?, ?)");

        } catch (Exception exception) {
            System.out.println("[connectToDB Method] Something Went Wrong At: " + exception); //Print to screen
        } //End of try-catch Block

    } //End of connectToDB Method

    //insertToDB Method
    public void insertToDB(String studentID, double termOneGPA, double termTwoGPA, double termThreeGPA) {

        //try-catch Block
        try {

            //If Statement - To Check If Connection To SQL Database Is Open Or Closed
            if (!connection.isClosed()) {

                //Insert values into the SQL Database
                insertStatement.setString(1, studentID);
                insertStatement.setDouble(2, termOneGPA);
                insertStatement.setDouble(3, termTwoGPA);
                insertStatement.setDouble(4, termThreeGPA);

                //Int Variable That Will Hold How Many Row(s) of Data Have Been Inserted Into The SQL Database
                int numberOfRowsAdded = insertStatement.executeUpdate();

                //Child If Statement - To Check if value of variable "numberOfRowsAdded" is greater then 0
                if (numberOfRowsAdded > 0) {
                    System.out.println("[insertToDB] " + numberOfRowsAdded + " Record(s) Inserted Successfully!!!");
                    //this.showAllBooks();
                } else {
                    System.out.println("[insertToDB] Insertion of Record(s) Failed!!!");
                } //End of Child If Statement

            } else {
                System.out.println("[insertToDB] Connection To Database Is Closed, Data Can Not Be Inserted!!!");
            } //End of If Statement

        } catch (SQLException exception) {
            System.out.println("[insertToDB] FAILED, Insertion of Data Into The Database: " + exception);
        } //End of try-catch Block

    } //End of insertInToDB Method

    //showStudentRecords Method
    private void showStudentRecords() {

        //Create A SQL SELECT Query String Using Table Name
        String query = "SELECT * FROM " + table_name;
        System.out.println("Query: " + query); //Print To Screen

        //try-catch Block
        try {

            //If Statement - To Check If Connection To SQL Server Is Open Or Closed
            if (connection.isClosed()) {
                System.out.println("[showStudentRecords] No connection to retrieve data from...."); //Print To Screen
            } else {
                System.out.println("Retrieving Data From Database..."); //Print To Screen

                //Create A Statement Object To Execute SQL Queries
                Statement selectStatement = connection.createStatement();
                //Result after executing the select query against the database
                ResultSet resultSet = selectStatement.executeQuery((query));
                //Additional information such as colum name for retrieved result
                ResultSetMetaData metaData = resultSet.getMetaData();

                //Int Variable Holding The Number of Fields Retrieved From Database
                int columnCount = metaData.getColumnCount();

                StudentGrades currentStudentsGrade = new StudentGrades();
                //Remove Existing Data From BookList To Avoid Duplicate Records In Table View
                this.studentGradesList.clear();

                //While Loop - To Iterate Through The Rows of resultSet From Database Query
                while (resultSet.next()) {

                    //For Loop - To Output Each Colum
                    for (int col = 1; col <= columnCount; col++) {
                        System.out.println("Column Name: " + metaData.getCatalogName(col) +
                                " --- " + resultSet.getString(col));
                    } //End of For Loop

                    System.out.println("Running......."); //Print to screen

                    //Set The Record Fields To TableView's Columns
                    currentStudentsGrade = new StudentGrades();
                    currentStudentsGrade.studentID.set(resultSet.getString(1));
                    currentStudentsGrade.termOneGPA.set(resultSet.getDouble(2));
                    currentStudentsGrade.termTwoGPA.set(resultSet.getDouble(3));
                    currentStudentsGrade.termThreeGPA.set(resultSet.getDouble(4));

                    currentStudentsGrade.calculateCumulativeGPA();

                    //Add current Book To the array
                    this.studentGradesList.add(currentStudentsGrade);

                    //Set "studentGradesList" Array As Source For TableView To Use Data To Display
                    tvStudentGrades.setItems(studentGradesList);
                    //Update TableView with "refresh();" to show the records
                    tvStudentGrades.refresh();

                } //End of While Loop

            } //End of If Statement

        } catch (SQLException exception) {
            System.out.println("[showStudentRecords] Unable to retrieve records fom DB due to error: " + exception);
        } //End of try-catch Block

    } //End of showStudentRecords Method

} //End of HelloController Method