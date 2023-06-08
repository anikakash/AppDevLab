package com.example.labfinla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        res = findViewById(R.id.show);
        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();

        Bundle binder = getIntent().getExtras();
        String name = binder.getString("Name");
        String age = binder.getString("age");

       Double ageint = Double.parseDouble(age);
        res.setText(age);
//
        if(ageint>=18){
            res.setText(name+ "Congratulations You can vote!");
        }else{
            res.setText(name+ "Sorry your not Enogh for voing!");
        }
    }
}