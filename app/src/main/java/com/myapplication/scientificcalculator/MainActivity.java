package com.myapplication.scientificcalculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity implements View.OnClickListener {



    private TextView inputDisplay;
    private boolean isInProcess = false;
    /*private CalculatorBrain mCalculatorBrain;*/
    private static final String NUMBERS = ".0123456789";
    private Calculations mCalculations ;

    DecimalFormat df = new DecimalFormat("@##########");

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

                requestWindowFeature(Window.FEATURE_NO_TITLE);

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

        mCalculations = new Calculations();
        inputDisplay = (TextView) findViewById(R.id.textView1);


        df.setMaximumFractionDigits(0);
        df.setMinimumIntegerDigits(1);
        df.setMaximumIntegerDigits(9);

        findViewById(R.id.number0).setOnClickListener(this);
        findViewById(R.id.number1).setOnClickListener(this);
        findViewById(R.id.number2).setOnClickListener(this);
        findViewById(R.id.number3).setOnClickListener(this);
        findViewById(R.id.number4).setOnClickListener(this);
        findViewById(R.id.number5).setOnClickListener(this);
        findViewById(R.id.number6).setOnClickListener(this);
        findViewById(R.id.number7).setOnClickListener(this);
        findViewById(R.id.number8).setOnClickListener(this);
        findViewById(R.id.number9).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);
        findViewById(R.id.buttonDecimalPoint).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonSubtract).setOnClickListener(this);
        findViewById(R.id.plusMinus).setOnClickListener(this);
        findViewById(R.id.scientific).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        String buttonPress = ((Button)v).getText().toString();

        //if button pressed is change
        //calculator changes to scientific calculator
        if(buttonPress.equalsIgnoreCase("change")){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

        if (NUMBERS.contains(buttonPress)) {

            // number was pressed
            if (isInProcess) {

                if (buttonPress.equals(".")){
                    if(inputDisplay.getText().toString().contains(".")){
                    }} else {
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
            // operation was pressed
            if (isInProcess) {
                mCalculations.setInputtedNumber(Double.parseDouble(inputDisplay.getText().toString()));
                isInProcess = false;
                }
            mCalculations.performCalculation(buttonPress);
           inputDisplay.setText(df.format(mCalculations.getResult()));
           }
        }

    @Override
   protected void onSaveInstanceState(Bundle outState) {
       super.onSaveInstanceState(outState);
        // Save variables on screen orientation change
       outState.putDouble("OPERAND", mCalculations.getResult());
        outState.putDouble("MEMORY", mCalculations.getMemory());
       }

    @Override
   protected void onRestoreInstanceState(Bundle savedInstanceState) {
       super.onRestoreInstanceState(savedInstanceState);
       // Restore variables on screen orientation change
        mCalculations.setInputtedNumber(savedInstanceState.getDouble("OPERAND"));
        mCalculations.setMemory(savedInstanceState.getDouble("MEMORY"));
        inputDisplay.setText(df.format(mCalculations.getResult()));
        }

}


