package com.bignerdranch.android.mysharedprefencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.edit1);
        mAge = findViewById(R.id.edit2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("MyOwnShared", MODE_PRIVATE);

        String name = sharedPreferences.getString("user", "");
        int age = sharedPreferences.getInt("age", 0);

        mName.setText(name);
        mAge.setText(String.valueOf(age));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MyOwnShared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", mName.getText().toString());
        editor.putInt("age", Integer.parseInt(mAge.getText().toString()));
        editor.commit();
    }
}
