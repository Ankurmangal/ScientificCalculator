package com.myapplication.scientificcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.text.TextUtils;

import java.text.DecimalFormat;

public class MainActivity extends Activity implements View.OnClickListener {


    private TextView inputDisplay;
    private boolean isInProcess = true;
    /*private CalculatorBrain mCalculatorBrain;*/
    private static final String NUMBERS = ".0123456789";

    DecimalFormat df = new DecimalFormat("@######");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }

    @Override
    public void onClick (View v) {

        String buttonPress = ((Button)v).getText().toString();


        //if button pressed is change
        //calculator changes to scientific calculator
        if(buttonPress.equalsIgnoreCase("change")){

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

        //proceeding if the button pressed containg any number form (.,0,1,2,3,4,5,6,7,8,9)
        if (NUMBERS.contains(buttonPress)){

            //user is still wrtitng
            if(isInProcess == true){
                if(buttonPress.equals(".")){
                    inputDisplay.setText(0 +buttonPress);
                }
                else{inputDisplay.setText(buttonPress);

                }

            }

        }

    }


}
