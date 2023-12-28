package com.example.abraar_final;

//Import
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

//HelloController Class
public class HelloController implements Initializable {

    //Class Property's For TextFields
    @FXML private TextField tfAccountNumber;
    @FXML private TextField tfHydroConsumptionUnits;

    //Class Property's For Radio Buttons & Toggle Group
    @FXML private RadioButton rdbSummer;
    @FXML private RadioButton rdbWinter;
    @FXML private RadioButton rdbFall;
    @FXML private ToggleGroup toggleGroup;

    //Class Property's For Label
    @FXML private Label outPut;

    //Class Property's For Name of SQL Table
    private final String table_name = "ABRAAR_HYDRO";

    //Class Property's For SQL Connection
    private Connection connection;

    //Class Property For SQL Insert Property
    private PreparedStatement insertStatement;

    //Class Property's For Table View
    @FXML private TableView<HydroBillRecords> tvStoredHydroBillCalculation;
    @FXML private TableColumn<HydroBillRecords, String> colAccountNumber;
    @FXML private TableColumn<HydroBillRecords, Integer> colHydroUnits;
    @FXML private TableColumn<HydroBillRecords, String> colSeason;
    @FXML private TableColumn<HydroBillRecords, Double> colHydroBillEstimate;
    private ObservableList<HydroBillRecords> hydroBillRecordsList = FXCollections.observableArrayList();

    //initialize Method
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Set Toggle Group
        this.toggleGroup = new ToggleGroup();
        this.rdbSummer.setToggleGroup(this.toggleGroup);
        this.rdbWinter.setToggleGroup(this.toggleGroup);
        this.rdbFall.setToggleGroup(this.toggleGroup);

        //Initialize the table columns
        this.colAccountNumber = new TableColumn<>("Account Number");
        this.colAccountNumber.setCellValueFactory(new PropertyValueFactory<HydroBillRecords, String>("accountNumber"));
        this.colHydroUnits = new TableColumn<>("Hydro Units (Kilowatt)");
        this.colHydroUnits.setCellValueFactory(new PropertyValueFactory<HydroBillRecords, Integer>("hydroConsumptionUnits"));
        this.colSeason = new TableColumn<>("Season");
        this.colSeason.setCellValueFactory(new PropertyValueFactory<HydroBillRecords, String>("season"));
        this.colHydroBillEstimate = new TableColumn<>("Hydro Bill Estimate");
        this.colHydroBillEstimate.setCellValueFactory(new PropertyValueFactory<HydroBillRecords, Double>("hydroBillEstimate"));

        //Set All of The Above Columns To The Following Table View
        this.tvStoredHydroBillCalculation.getColumns().addAll(colAccountNumber, colHydroUnits, colSeason, colHydroBillEstimate);

        //Call Method's
        connectToDB();
        this.showHydroBillRecords();

    } //End of initialize Method

    //onGetEstimateClick Method
    @FXML
    protected void onGetEstimateClick() {

        String outputMessage = " "; //String variable to hold Output Message

        String accountNumber = "";
        int hydroConsumptionUnits = 000;
        String season = "";
        double hydroBillEstimate = 0.00;

        //If Statement - To check if "tfAccountNumber is empty
        if (tfAccountNumber.getText().isEmpty()) {
            outputMessage += "\n[onGetEstimateClick] Account Number Field Can Not Be Left Empty";
        } else {
            accountNumber = tfAccountNumber.getText().toString();
            outputMessage += "\n[onGetEstimateClick] The Account Number Is: " + accountNumber;
        } //End of If Statement

        //If Statement - To check if "tfHydroConsumptionUnits is empty
        if (tfHydroConsumptionUnits.getText().isEmpty()) {
            outputMessage += "\n[onGetEstimateClick] Hydro Consumption Units Field Can Not Be Left Empty";
        } else {
            hydroConsumptionUnits = Integer.parseInt(tfHydroConsumptionUnits.getText().toString());
            outputMessage += "\n[onGetEstimateClick] The Hydro Consumption Units Is: " + hydroConsumptionUnits;
        } //End of If Statement

        //Retrieve the selected radio button from toggle group
        RadioButton selectedRadioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
        //If Statement - That checks which radio button is selected, and apply a surcharge depending on which button is selected
        if (Objects.equals(selectedRadioButton.getText(), "SUMMER")) {
            season = rdbSummer.getText().toString();
            hydroBillEstimate = hydroConsumptionUnits * 0.50; //Calculate
            outputMessage += "\nSummer Fee: $0.50 Per-Kilowatt";
        } else if (Objects.equals(selectedRadioButton.getText(), "WINTER")) {
            season = rdbWinter.getText().toString();
            hydroBillEstimate = hydroConsumptionUnits * 0.70; //Calculate
            outputMessage += "\nWinter Fee: $0.70 Per-Kilowatt";
        } else if (Objects.equals(selectedRadioButton.getText(), "FALL")) {
            season = rdbFall.getText().toString();
            hydroBillEstimate = hydroConsumptionUnits * 0.30; //Calculate
            outputMessage += "\nFall Fee: $0.30 Per-Kilowatt";
        }

        outPut.setText(outputMessage);
        System.out.println(outputMessage); //Print to screen

        //try-catch Block - To Make Sure That All Fields Have Been Filed Before Inserting Data Into Database
        try {
            insertToDB(accountNumber, hydroConsumptionUnits, season, hydroBillEstimate); //Call Method With Following Parameters
            this.showHydroBillRecords();
        } catch (Exception exception) {
            System.out.println("\n[onGetEstimateClick] Something Went Wrong When Trying To Insert Data Into Database At: " + exception);
            System.out.println("[onGetEstimateClick] Please Ensure That All Fields Have Been Field");
        } //End of try-catch Block

    } //End of onGetEstimateClick Method

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
    public void insertToDB(String accountNumber, int hydroConsumptionUnits, String season, double hydroBillEstimate) {

        //try-catch Block
        try {

            //If Statement - To Check If Connection To SQL Database Is Open Or Closed
            if (!connection.isClosed()) {

                //Insert values into the SQL Database
                insertStatement.setString(1, accountNumber);
                insertStatement.setInt(2, hydroConsumptionUnits);
                insertStatement.setString(3, season);
                insertStatement.setDouble(4, hydroBillEstimate);

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

    //showHydroBillRecords Method
    private void showHydroBillRecords() {

        //Create A SQL SELECT Query String Using Table Name
        String query = "SELECT * FROM " + table_name;
        System.out.println("Query: " + query); //Print To Screen

        //try-catch Block
        try {

            //If Statement - To Check If Connection To SQL Server Is Open Or Closed
            if (connection.isClosed()) {
                System.out.println("[showHydroBillRecords] No connection to retrieve data from...."); //Print To Screen
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

                HydroBillRecords currentHydroBill = new HydroBillRecords();
                //Remove Existing Data From BookList To Avoid Duplicate Records In Table View
                this.hydroBillRecordsList.clear();

                //While Loop - To Iterate Through The Rows of resultSet From Database Query
                while (resultSet.next()) {

                    //For Loop - To Output Each Colum
                    for (int col = 1; col <= columnCount; col++) {
                        System.out.println("Column Name: " + metaData.getCatalogName(col) +
                                " --- " + resultSet.getString(col));
                    } //End of For Loop

                    System.out.println("Running......."); //Print to screen

                    //Set The Record Fields To TableView's Columns
                    currentHydroBill = new HydroBillRecords();
                    currentHydroBill.accountNumber.set(resultSet.getString(1));
                    currentHydroBill.hydroConsumptionUnits.set(resultSet.getInt(2));
                    currentHydroBill.season.set(resultSet.getString(3));
                    currentHydroBill.hydroBillEstimate.set(resultSet.getDouble(4));

                    //Add current Book To the array
                    this.hydroBillRecordsList.add(currentHydroBill);

                    //Set "studentGradesList" Array As Source For TableView To Use Data To Display
                    tvStoredHydroBillCalculation.setItems(hydroBillRecordsList);
                    //Update TableView with "refresh();" to show the records
                    tvStoredHydroBillCalculation.refresh();

                } //End of While Loop

            } //End of If Statement

        } catch (SQLException exception) {
            System.out.println("[showHydroBillRecords] Unable to retrieve records fom DB due to error: " + exception);
        } //End of try-catch Block

    } //End of showHydroBillRecords Method

} //End of HelloController Class