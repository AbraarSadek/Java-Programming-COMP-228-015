package com.example.abraar_15_lab4;

//import
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.text.DecimalFormat;

//Class HelloController
public class HelloController implements Initializable {

    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    //Combo Box's
    @FXML private ComboBox cmbItems;
    @FXML private ObservableList<String> cmbItemList = FXCollections.observableArrayList("Mangoes: $8.89",
            "Bread: $4.75", "Strawberries: $3.99", "Egg Carton: $6.47", "Bagged Milk: $10.95");
    @FXML private ComboBox cmbQuantity;
    @FXML private ObservableList cmbQuantityList = FXCollections.observableArrayList("1",
            "2", "3", "4", "5", "7", "9", "10");

    //Text Fields
    @FXML private TextField tfFullName;
    @FXML private TextField tfAddress;

    //Radio Buttons & Toggle Group
    @FXML private RadioButton rdbPickUp;
    @FXML private RadioButton rdbHomeDelivery;
    @FXML private ToggleGroup toggleGroup;

    //Label To Display "Receipt"
    @FXML private Label receipt;

    //Variables For Payment Management
    int mangoesQuantity = 0;
    int breadQuantity = 0;
    int strawberryQuantity = 0;
    int eggCartonQuantity = 0;
    int baggedMilkQuantity = 0;

    //initialize Method
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Assign "cmbItemList" value to "cmbItems"
        cmbItems.setItems(cmbItemList);
        //Assign "cmbQuantityList" value to "cmbQuantity"
        cmbQuantity.setItems(cmbQuantityList);

        //Set Toggle Group
        this.toggleGroup = new ToggleGroup();
        this.rdbPickUp.setToggleGroup(this.toggleGroup);
        this.rdbHomeDelivery.setToggleGroup(this.toggleGroup);

    } //End of initialize Method

    //onClearReceiptButtonClick Method
    @FXML protected void onClearReceiptButtonClick() {

        //Initialize All Variables To Zero
        int mangoesQuantity = 0;
        int breadQuantity = 0;
        int strawberryQuantity = 0;
        int eggCartonQuantity = 0;
        int baggedMilkQuantity = 0;

        receipt.setText("Receipt Has Been Cleared!!!"); //Set Label "receipt" Text

    } //End of onClearReceiptButtonClick Method

    //onAddItemButtonClick Method
    @FXML protected void onAddItemButtonClick() {

        //Try-Catch - To make sure an item had been selected before added to order
        try {

            String itemSelection = cmbItems.getValue().toString(); //Store item selection from combo box "cmbItems" into String variable "itemSelection"

            //Switch Statement
            switch (itemSelection) {
                case "Mangoes: $8.89" :
                    mangoesQuantity = Integer.parseInt(cmbQuantity.getValue().toString());
                    break;
                case "Bread: $4.75" :
                    breadQuantity = Integer.parseInt(cmbQuantity.getValue().toString());
                    break;
                case "Strawberries: $3.99" :
                    strawberryQuantity = Integer.parseInt(cmbQuantity.getValue().toString());
                    break;
                case "Egg Carton: $6.47" :
                    eggCartonQuantity = Integer.parseInt(cmbQuantity.getValue().toString());
                    break;
                case "Bagged Milk: $10.95" :
                    baggedMilkQuantity = Integer.parseInt(cmbQuantity.getValue().toString());
                    break;
                default:
                    System.out.println("Error!!! " + itemSelection + " Is Invalid.");
            } //End of Switch Statement
            receipt.setText("Item(s): " + itemSelection + " Added To Order!");

        } catch (Exception e) {
            receipt.setText("Both Item & Quantity Selection Required, Before Being Adding Another Item To Cart Or Proceeding To Check Out.");
        } //End of Try-Catch

    } //End of onAddItemButtonClick Method

    //onPlaceOrderButtonClick Method
    @FXML protected void onPlaceOrderButtonClick() {

        //String vairbale that will be used to store the output for the receipt label
        String receiptOutput = ""; //String to hold receipt

        //If Statement - To check if text field "tfFullName" and text field "tfAddress" are filled
        if (tfFullName.getText().isEmpty() || tfAddress.getText().isEmpty()) {
            receiptOutput += "Name AND/OR Address Fields Cannot Be Left Empty!!!";
            receipt.setText(receiptOutput);
        } else {

            double finalPrice = 0.00; //Double variable that will hold the final price
            double tax; //Double variable holding final price including tax

            //Set Full Name And Address text field value to variable "receiptOutput"
            receiptOutput += "Full Name: "+ tfFullName.getText() +
                             "\nAddress: " + tfAddress.getText();

            //If Statement - To check that mangoes quantity is not less then or equals to 0
            if (mangoesQuantity != 0) {
                receiptOutput += "\nMangoes: " + mangoesQuantity;
                finalPrice += (mangoesQuantity * 8.89); //Concatenate price for mangoes to variable "finalPrice"
            } //End of If Statement

            //If Statement - To check that bread quantity is not less then or equals to 0
            if (breadQuantity != 0) {
                receiptOutput += "\nBread: " + breadQuantity;
                finalPrice += (breadQuantity * 4.75); //Concatenate price for bread to variable "finalPrice"
            } //End of If Statement

            //If Statement - To check that strawberry quantity is not less then or equals to 0
            if (strawberryQuantity != 0) {
                receiptOutput += "\nStrawberries: " + strawberryQuantity;
                finalPrice += (strawberryQuantity * 3.99); //Concatenate price for bread to variable "finalPrice"
            } //End of If Statement

            //If Statement - To check that egg carton quantity is not less then or equals to 0
            if (eggCartonQuantity != 0) {
                receiptOutput += "\nEgg Cartons: " + eggCartonQuantity;
                finalPrice += (eggCartonQuantity * 6.47); //Concatenate price for bread to variable "finalPrice"
            } //End of If Statement

            //If Statement - To check that bagged milf quantity is not less then or equals to 0
            if (baggedMilkQuantity != 0) {
                receiptOutput += "\nBagged Milk: " + baggedMilkQuantity;
                finalPrice += (baggedMilkQuantity * 10.95); //Concatenate price for bread to variable "finalPrice"
            } //End of If Statement

            //Retrieve the selected radio button from toggle group
            RadioButton selectedRadioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
            //If Statement - That checks which radio button is selected, and applies a $5 surcharge if It's for Home-Delivery
            if (Objects.equals(selectedRadioButton.getText(), "Home-Delivery")) {
                receiptOutput += "\nDelivery Fee: $5";
                finalPrice += 5.00;
            }

            tax = finalPrice * 0.13; //Calculate tax owed for final price
            receiptOutput += "\nFinal Price Before Tax: $" + decfor.format(finalPrice)
                           + "\nTax: $" + decfor.format(tax)
                           + "\nFinal Price After Tax: $" + decfor.format((finalPrice + tax));

        } //End of If Statement

        receipt.setText(receiptOutput); //Set value of string "receiptOutput" to label "receipt"

    } //End of onPlaceOrderButtonClick Method

} //End of Class HelloController