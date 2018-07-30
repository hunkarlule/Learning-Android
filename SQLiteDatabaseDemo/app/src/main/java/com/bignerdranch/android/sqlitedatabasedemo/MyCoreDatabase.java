package com.bignerdranch.android.sqlitedatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyCoreDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "education";
    private static final String DB_TABLE = "students";
    private static final int DB_VERSION = 1;

    Context mContext;
    SQLiteDatabase mDatabase;

    public MyCoreDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DB_TABLE + " (_id integer primary key autoincrement, stu_name text, college_name text);");
        Log.i("Database", "Table created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + DB_TABLE );
        onCreate(db);
    }

    public void insertData(String s1, String s2) {
        mDatabase = getWritableDatabase();
        mDatabase.execSQL("insert into " + DB_TABLE + " (stu_name, college_name) values('"+s1+"', '"+s2+"');");
        Toast.makeText(mContext, "Data saved successfully!", Toast.LENGTH_SHORT).show();
    }

    public void getData() {
        mDatabase = getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("Select * from " + DB_TABLE,null);
        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()) {
           String s1 = cursor.getString(1);
           String s2 = cursor.getString(2);
           stringBuilder.append(s1 + "             " + s2 + " \n");
        }
        Toast.makeText(mContext, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}
