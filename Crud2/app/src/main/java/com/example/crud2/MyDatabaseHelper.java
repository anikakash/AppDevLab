package com.example.crud2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String  DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_details";
    private static final int VERSION_NUMBER = 2;
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "GENDER";
    private static String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255),"+AGE+" INTEGER, "+GENDER+" VARCHAR(255));";
    private Context context;
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "onCreate is created",Toast.LENGTH_LONG).show();
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context,"Exception: "+e, Toast.LENGTH_LONG) .show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context,"onUpgrade is called", Toast.LENGTH_LONG) .show();
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Exception: "+e, Toast.LENGTH_LONG) .show();
        }
    }

    public long insertdata(String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("AGE",age);
        contentValues.put("GENDER",gender);

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null,contentValues);
        return  rowId;
    }
}
