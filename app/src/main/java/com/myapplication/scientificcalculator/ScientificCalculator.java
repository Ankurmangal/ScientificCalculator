package com.myapplication.scientificcalculator;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by ankur on 2015-11-14.
 */
public class ScientificCalculator extends Activity {





private double inputtedNumber;
private double mWaitingInputtedNumber;
private String waitingOperator;
private double mCalculatorMemory;

// operator types
public static final String ADD = "+";
public static final String SUBTRACT = "-";
public static final String MULTIPLY = "*";
public static final String DIVIDE = "/";

public static final String CLEAR = "C" ;
public static final String CLEARMEMORY = "MC";
public static final String ADDTOMEMORY = "M+";
public static final String SUBTRACTFROMMEMORY = "M-";
public static final String RECALLMEMORY = "MR";
public static final String SQUAREROOT = "√";
public static final String SQUARED = "x²";
public static final String INVERT = "1/x";
public static final String PLUSMINUS = "+/-";
public static final String SINE = "sin";
public static final String COSINE = "cos";
public static final String TANGENT = "tan";

    // public static final String EQUALS = "=";

    // constructor
    public ScientificCalculator() {
        // initialize variables upon start
        inputtedNumber = 0;
        mWaitingInputtedNumber = 0;
        waitingOperator = "";
        mCalculatorMemory = 0;
    }

    public void setOperand(double operand) {
        inputtedNumber = operand;
    }

    public double getResult() {
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



    protected double performSquare(String operator) {
        if (operator.equals(SQUARED)) {

            inputtedNumber = inputtedNumber * inputtedNumber;
        }
        return inputtedNumber;
    }

    protected double pressClear(String operator){
        if (operator.equals(CLEAR)) {
            inputtedNumber = 0;
            waitingOperator = "";
            mWaitingInputtedNumber = 0;
            mCalculatorMemory = 0;
        }
        return inputtedNumber;
    }

    protected double performSqaureRoot(String operator){
        if(operator.equals(SQUAREROOT)){
            inputtedNumber = Math.sqrt(inputtedNumber);
        }
        return inputtedNumber;
    }

    protected void pressClearMemory(String operator){
        if(operator.equals(CLEARMEMORY)){
            mCalculatorMemory = 0;
        }
    }

    protected void pressAddToMemory(String operator){
        if(operator.equals(ADDTOMEMORY)){
            mCalculatorMemory = mCalculatorMemory + inputtedNumber;
        }
    }

    protected void pressSubtractFromMemory(String operator){
        if(operator.equals(SUBTRACTFROMMEMORY)){
            mCalculatorMemory = mCalculatorMemory - inputtedNumber;
        }
    }

    protected void pressRecallMemory(String operator){
        if(operator.equals(RECALLMEMORY)){
            inputtedNumber = mCalculatorMemory;
        }
    }

    protected double performInvert(String operator){
        if(operator.equals(INVERT)){
            if(inputtedNumber == 0){
                Toast.makeText(ScientificCalculator.this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }
            else {
                inputtedNumber = 1 / inputtedNumber ;
            }
        }
        return inputtedNumber;
    }

    protected double pressPlusMinus(String operator){
        if(operator.equals(PLUSMINUS)){
            inputtedNumber = -inputtedNumber;
        }
        return inputtedNumber;
    }

    protected double performSine(String operator){
        if(operator.equals(SINE)){
            inputtedNumber =Math.sin(Math.toRadians(inputtedNumber));
        }
        return inputtedNumber;
    }

    protected double performCosine(String operator){
        if(operator.equals(COSINE)){
            inputtedNumber =Math.cos(Math.toRadians(inputtedNumber));
        }
        return inputtedNumber;
    }

    protected double performTangent(String operator){
        if(operator.equals(TANGENT)){
            inputtedNumber =Math.tan(Math.toRadians(inputtedNumber));
        }
        return inputtedNumber;
    }


    protected double performOperation(String operator) {

        if (operator.equals(ADD)) {
            inputtedNumber = mWaitingInputtedNumber + inputtedNumber;
        } else if (operator.equals(SUBTRACT)) {
            inputtedNumber = mWaitingInputtedNumber - inputtedNumber;
        } else if (operator.equals(MULTIPLY)) {
            inputtedNumber = mWaitingInputtedNumber * inputtedNumber;
        } else if (operator.equals(DIVIDE)) {
            if (inputtedNumber != 0) {
                inputtedNumber = mWaitingInputtedNumber / inputtedNumber;
            }
        }
        return inputtedNumber;
    }



    }