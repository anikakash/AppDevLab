package com.example.labfinla;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1, editText2;
    private Button checkbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.user);
        editText2 = findViewById(R.id.age);

        checkbtn = findViewById(R.id.checkbtn);
        checkbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.checkbtn){

            String name = editText1.getText().toString();
            String age=editText2.getText().toString();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("Name", name);
            intent.putExtra("age", age);
            startActivity(intent);
        }
    }
}