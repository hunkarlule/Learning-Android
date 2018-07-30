package com.bignerdranch.android.expressouitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);
    }

    public void doSomething(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key1", mEditText.getText().toString());
        startActivity(intent);
    }


}
