package com.example.abraar_15_lab5;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DecimalFormat;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 11/28/2023
 */

//StudentGrades Class
public class StudentGrades {

    //StudentGrades Property's
    public SimpleStringProperty studentID = new SimpleStringProperty();
    public SimpleDoubleProperty termOneGPA = new SimpleDoubleProperty();
    public SimpleDoubleProperty termTwoGPA = new SimpleDoubleProperty();
    public SimpleDoubleProperty termThreeGPA = new SimpleDoubleProperty();
    public SimpleDoubleProperty cumulativeGPA = new SimpleDoubleProperty();


    //Getters & Setters
    public String getStudentID() { return studentID.get(); }
    public SimpleStringProperty studentIDProperty() { return studentID; }
    public void setStudentID(String studentID) { this.studentID.set(studentID); }
    public double getTermOneGPA() { return termOneGPA.get(); }
    public SimpleDoubleProperty termOneGPAProperty() { return termOneGPA; }
    public void setTermOneGPA(double termOneGPA) { this.termOneGPA.set(termOneGPA); }
    public double getTermTwoGPA() { return termTwoGPA.get(); }
    public SimpleDoubleProperty termTwoGPAProperty() { return termTwoGPA; }
    public void setTermTwoGPA(double termTwoGPA) { this.termTwoGPA.set(termTwoGPA); }
    public double getTermThreeGPA() { return termThreeGPA.get(); }
    public SimpleDoubleProperty termThreeGPAProperty() { return termThreeGPA; }
    public void setTermThreeGPA(double termThreeGPA) { this.termThreeGPA.set(termThreeGPA); }
    public double getCumulativeGPA() { return cumulativeGPA.get(); }
    public SimpleDoubleProperty cumulativeGPAProperty() { return cumulativeGPA; }
    public void setCumulativeGPA(double cumulativeGPA) { this.cumulativeGPA.set(cumulativeGPA); }
    //End of Getters & Setters

    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    //calculateCumulativeGPA Method
    public void calculateCumulativeGPA() {

        cumulativeGPA.set(Double.parseDouble(decfor.format((termOneGPA.get() + termTwoGPA.get() + termThreeGPA.get()) / 3)));

    } //End of calculateCumulativeGPA Method



} //End of StudentGrades Class
