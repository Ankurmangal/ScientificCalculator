package com.myapplication.scientificcalculator;

import android.app.Activity;

/**
 * Created by ankur on 2015-11-12.
 */
public class Calculations extends Activity {


    private double inputtedNumber; //private double mOperand;
    private String waitingOperator;//  private String mWaitingOperator;
    private double mWaitingInputtedNumber;//private double mWaitingOperand;
    private double mCalculatorMemory;//     private double mCalculatorMemory;


    public static final String ADDITION = "+";
    public static final String MULTIPLICATION = "*";
    public static final String DIVIDE = "/";
    public static final String SUBTRACTION = "-";
    public static final String PLUSMINUS = "+/-";
    public static final String CLEAR = "C";
    public static final String CHANGE = "CHANGE";



    //constructor
    public Calculations() {
        // initialize variables upon start
        inputtedNumber = 0;
        waitingOperator = "";
        mWaitingInputtedNumber = 0;
        mCalculatorMemory = 0;

    }


    public void setInputtedNumber(double input) {
        inputtedNumber = input;
    }

    public double getResult() {
        return inputtedNumber;
    }


    public void setMemory(double calculatorMemory) {
        mCalculatorMemory = calculatorMemory;
    }


    public double getMemory() {
        return mCalculatorMemory;
    }

    public String toString() {
        return Double.toString(inputtedNumber);
    }


    protected double performCalculation(String operator) {


        if (operator.equals(CLEAR)) {
            inputtedNumber = 0;
            waitingOperator = "";
            mWaitingInputtedNumber = 0;
            // mCalculatorMemory = 0;
        } else {
            if(operator.equals(PLUSMINUS)){
                inputtedNumber = -inputtedNumber;
            }
            if (waitingOperator.equals(ADDITION)) {
                inputtedNumber = mWaitingInputtedNumber + inputtedNumber;
            } else if (waitingOperator.equals(SUBTRACTION)) {
                inputtedNumber = mWaitingInputtedNumber - inputtedNumber;
            } else if (waitingOperator.equals(MULTIPLICATION)) {
                inputtedNumber = mWaitingInputtedNumber * inputtedNumber;
            } else if (waitingOperator.equals(DIVIDE)) {
                if (inputtedNumber != 0) {
                    inputtedNumber = mWaitingInputtedNumber / inputtedNumber;
                }

            }
            waitingOperator = operator;
            mWaitingInputtedNumber = inputtedNumber;
        }

        return inputtedNumber;
    }
}



