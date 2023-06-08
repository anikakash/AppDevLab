package com.example.basicmathclaculator;


import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextnum1, editTextnum2;
    private Button sumbutton, mulbutton, divbutton, subbutton;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextnum1=findViewById(R.id.EditTextnum1ID);
        editTextnum2=findViewById(R.id.EditTextnum2ID);
        sumbutton=findViewById(R.id.sumButtonID);
        mulbutton=findViewById((R.id.mulButtonID));
        divbutton=findViewById((R.id.divButtonID));
        subbutton=findViewById(R.id.subButtonID);
        resultTextView=findViewById(R.id.ResultTextViewID);

        sumbutton.setOnClickListener(this);
        mulbutton.setOnClickListener(this);
        divbutton.setOnClickListener(this);
        subbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String num1=editTextnum1.getText().toString();
        String num2=editTextnum2.getText().toString();
        double number1=Double.parseDouble(num1);
        double number2=Double.parseDouble(num2);
        if(view.getId()==R.id.sumButtonID){
            double result= number1+number2;
            resultTextView.setText("result is: "+result);
        }
        else if(view.getId()==R.id.mulButtonID){
            double result= number1*number2;
            resultTextView.setText("result is: "+result);
        }
        else if(view.getId()==R.id.divButtonID){
            double result = number1/number2;
            resultTextView.setText("result is: "+result);
        }else {
            double result = abs(number1-number2);
            resultTextView.setText("result is: "+result);
        }


    }
}