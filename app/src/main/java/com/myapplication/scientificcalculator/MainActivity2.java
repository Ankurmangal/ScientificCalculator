package com.myapplication.scientificcalculator;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity implements OnClickListener {

    private TextView inputDisplay;
    public static final String SQUARED = "x²";
    public static final String CLEAR = "C";
    public static final String SQUAREROOT = "√";
    public static final String CLEARMEMORY = "MC";
    public static final String ADDTOMEMORY = "M+";
    public static final String SUBTRACTFROMMEMORY = "M-";
    public static final String RECALLMEMORY = "MR";
    public static final String INVERT = "1/x";
    public static final String PLUSMINUS = "+/-";
    public static final String SINE = "sin";
    public static final String COSINE = "cos";
    public static final String TANGENT = "tan";

    int clickCount = 0;

    private Boolean isInProcess = false;

    private ScientificCalculator mScientificCalculator;

    private static final String DIGITS = "0123456789.";

    DecimalFormat df = new DecimalFormat("@###########");

    @SuppressLint("NewApi")
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_2);

        mScientificCalculator = new ScientificCalculator();

        inputDisplay = (TextView) findViewById(R.id.textView1);

        df.setMinimumFractionDigits(0);
        df.setMinimumIntegerDigits(1);
        df.setMaximumIntegerDigits(8);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);

        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonSubtract).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonToggleSign).setOnClickListener(this);
        findViewById(R.id.buttonDecimalPoint).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);
        findViewById(R.id.buttonClearMemory).setOnClickListener(this);
        findViewById(R.id.buttonAddToMemory).setOnClickListener(this);
        findViewById(R.id.buttonSubtractFromMemory).setOnClickListener(this);
        findViewById(R.id.buttonRecallMemory).setOnClickListener(this);

        if (findViewById(R.id.buttonSquareRoot) != null) {
            findViewById(R.id.buttonSquareRoot).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonSquared) != null) {
            findViewById(R.id.buttonSquared).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonInvert) != null) {
            findViewById(R.id.buttonInvert).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonSine) != null) {
            findViewById(R.id.buttonSine).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonCosine) != null) {
            findViewById(R.id.buttonCosine).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonTangent) != null) {
            findViewById(R.id.buttonTangent).setOnClickListener(this);
        }
    }


    @Override

    public void onClick(View v) {


        clickCount++;

        if (clickCount == 1){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity2.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("For a good experience use scientific calculator horizontally");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            alertDialog.show();

        }

        String buttonPress = ((Button) v).getText().toString();


        if (DIGITS.contains(buttonPress)) {
            if (isInProcess) {

                if (buttonPress.equals(".") && inputDisplay.getText().toString().contains(".")) {
                } else {
                    inputDisplay.append(buttonPress);
                }
            } else {
                if (buttonPress.equals(".")) {
                    inputDisplay.setText(0 + buttonPress);
                } else {
                    inputDisplay.setText(buttonPress);
                }

                isInProcess = true;
            }
        } else {
            if (isInProcess) {

                mScientificCalculator.setOperand(Double.parseDouble(inputDisplay.getText().toString()));
                isInProcess = false;

            }
            mScientificCalculator.performOperation(buttonPress);
            inputDisplay.setText(df.format(mScientificCalculator.getResult()));
        }

        if (buttonPress.equals(SQUARED)) {
            mScientificCalculator.performSquare(buttonPress);
            inputDisplay.setText(df.format(mScientificCalculator.getResult()));
        }

        if (buttonPress.equals(CLEAR)) {

            mScientificCalculator.pressClear(buttonPress);
            inputDisplay.setText(df.format(mScientificCalculator.getResult()));
        }

        if (buttonPress.equals(SQUAREROOT)) {

            mScientificCalculator.performSqaureRoot(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }

        if (buttonPress.equals(CLEARMEMORY)) {

            mScientificCalculator.pressClearMemory(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }

        if (buttonPress.equals(ADDTOMEMORY)) {

            mScientificCalculator.pressAddToMemory(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }

        if (buttonPress.equals(SUBTRACTFROMMEMORY)) {

            mScientificCalculator.pressSubtractFromMemory(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }

        if (buttonPress.equals(RECALLMEMORY)) {

            mScientificCalculator.pressRecallMemory(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }

        if (buttonPress.equals(INVERT)) {
            mScientificCalculator.performInvert(buttonPress);
            inputDisplay.setText(df.format(mScientificCalculator.getResult()));
        }


        if (buttonPress.equals(PLUSMINUS)) {
            mScientificCalculator.pressPlusMinus(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }


        if (buttonPress.equals(SINE)) {
            mScientificCalculator.performSine(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }


        if (buttonPress.equals(COSINE)) {
            mScientificCalculator.performCosine(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }


        if (buttonPress.equals(TANGENT)) {
            mScientificCalculator.performTangent(buttonPress);
            inputDisplay.setText((df.format(mScientificCalculator.getResult())));
        }

    }


    @Override


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save variables on screen orientation change
        outState.putDouble("OPERAND", mScientificCalculator.getResult());
        outState.putDouble("MEMORY", mScientificCalculator.getMemory());
    }

    @Override


    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore variables on screen orientation change
        mScientificCalculator.setOperand(savedInstanceState.getDouble("OPERAND"));
        mScientificCalculator.setMemory(savedInstanceState.getDouble("MEMORY"));
        inputDisplay.setText(df.format(mScientificCalculator.getResult()));
    }

}
