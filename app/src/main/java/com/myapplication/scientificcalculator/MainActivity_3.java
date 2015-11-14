package com.myapplication.scientificcalculator;

/**
 * Created by ankur on 2015-11-08.
 */
public class MainActivity_3 {


    private double inputtedNumber;
    private String operator;
    private double mWaitingInputtedNumber;
    private double mCalculatorMemory;


    public static final String ADDITION = "+";
    public static final String MULTIPLICATION = "*";
    public static final String DIVIDE = "/";
    public static final String SUBTRACTION = "-";
    public static final String PLUSMINUS = "+/-";
    public static final String CLEAR = "C";
    public static final String CHANGE = "CHANGE";


    //constructor
    public MainActivity_3() {
        // initialize variables upon start
        inputtedNumber = 0;
        operator = "";
        mWaitingInputtedNumber = 0;
        mCalculatorMemory= 0;

    }


    public void inputNumber(double inputNumber){
        inputtedNumber = inputNumber;
    }

    public double getResult(){
        return inputtedNumber;

    }



    // used on screen orientation change
    public void setMemory(double calculatorMemory) {
        mCalculatorMemory = calculatorMemory;
    }

    // used on screen orientation change
    public double getMemory() {
        return mCalculatorMemory;
    }

    public String toString() {
        return Double.toString(inputtedNumber);
    }






}
