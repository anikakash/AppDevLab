package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText, ageEditText, genderEditText;
    private Button addButton;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.nameEditTextID);
        ageEditText = findViewById(R.id.ageEditTextID);
        genderEditText = findViewById(R.id.genderEditTextID);
        addButton = findViewById(R.id.addButtonID);
        addButton.setOnClickListener(this);
        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if(v.getId()==R.id.addButtonID){
            long rowId = myDatabaseHelper.insertdata(name,age,gender);
            if(rowId>0){
                Toast.makeText(getApplicationContext(), "Row"+rowId+"is successfully inserted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Row is not successfully inserted", Toast.LENGTH_SHORT).show();
            }
        }

    }
}