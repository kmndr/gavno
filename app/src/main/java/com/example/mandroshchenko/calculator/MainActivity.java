package com.example.mandroshchenko.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import expression.parser.ExpressionParser;


public class MainActivity extends AppCompatActivity {


    EditText Display;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button addition;
    Button subtract;
    Button multiply;
    Button division;
    Button equals;
    Button clear;
    Button point;

    final static int CLEAR = 1;
    final static int DONT_CLEAR = 0;
    int clearCalcDisplay = 0;

    private static String LOG_TAG = "MainActivity";
    private static final String KEY_CNT = "CNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero =  findViewById(R.id._0);
        one = findViewById(R.id._1);
        two = findViewById(R.id._2);
        three = findViewById(R.id._3);
        four = findViewById(R.id._4);
        five = findViewById(R.id._5);
        six = findViewById(R.id._6);
        seven = findViewById(R.id._7);
        eight = findViewById(R.id._8);
        nine = findViewById(R.id._9);
        addition = findViewById(R.id.add);
        subtract = findViewById(R.id.subctract);
        multiply = findViewById(R.id.multy);
        division = findViewById(R.id.division);
        point = findViewById(R.id.point);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equal);
        Display = findViewById(R.id._text);

        Display.setKeyListener(DigitsKeyListener.getInstance(true, true));

        registerListeners();

    }

    public void registerListeners() {

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("9");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("+");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("*");
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append("/");
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Display.append(".");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText("");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String expression = Display.getText().toString();
                if (expression.length() > 0) {
                    ExpressionParser parser = new ExpressionParser();
                    Double result = parser.parse(expression).evaluate(0);
                    Display.setText(result.toString());
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString(KEY_CNT, Display.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy: ");
    }
}
