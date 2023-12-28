package com.example.abraar_final;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DecimalFormat;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 12/11/2023
 */


//HydroBillRecords Class
public class HydroBillRecords {

    //HydroBillRecords Property's
    public SimpleStringProperty accountNumber = new SimpleStringProperty();
    public SimpleIntegerProperty hydroConsumptionUnits = new SimpleIntegerProperty();
    public SimpleStringProperty season = new SimpleStringProperty();
    public SimpleDoubleProperty hydroBillEstimate = new SimpleDoubleProperty();

    //Getters & Setters
    public String getAccountNumber() { return accountNumber.get(); }
    public SimpleStringProperty accountNumberProperty() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber.set(accountNumber); }
    public int getHydroConsumptionUnits() { return hydroConsumptionUnits.get(); }
    public SimpleIntegerProperty hydroConsumptionUnitsProperty() { return hydroConsumptionUnits; }
    public void setHydroConsumptionUnits(int hydroConsumptionUnits) { this.hydroConsumptionUnits.set(hydroConsumptionUnits); }
    public String getSeason() { return season.get(); }
    public SimpleStringProperty seasonProperty() { return season; }
    public void setSeason(String season) { this.season.set(season); }
    public double getHydroBillEstimate() { return hydroBillEstimate.get(); }
    public SimpleDoubleProperty hydroBillEstimateProperty() { return hydroBillEstimate; }
    public void setHydroBillEstimate(double hydroBillEstimate) { this.hydroBillEstimate.set(hydroBillEstimate); }
    //End of Getters & Setters

} //End of HydroBillRecords Class
