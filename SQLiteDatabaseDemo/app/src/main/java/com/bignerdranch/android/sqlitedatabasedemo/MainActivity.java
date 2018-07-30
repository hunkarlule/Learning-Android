package com.bignerdranch.android.sqlitedatabasedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mName, mCollege;
    private MyCoreDatabase mMyCoreDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.edit1);
        mCollege = findViewById(R.id.edit2);
        mMyCoreDatabase = new MyCoreDatabase(this);
    }

    public void doSave(View view) {
        mMyCoreDatabase.insertData(mName.getText().toString(), mCollege.getText().toString());
    }

    public void doLoad(View view) {
        mMyCoreDatabase.getData();
    }
}
