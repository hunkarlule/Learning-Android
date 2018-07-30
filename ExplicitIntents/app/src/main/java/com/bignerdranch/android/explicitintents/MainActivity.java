package com.bignerdranch.android.explicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 private EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.edit1);

    }

    public void dosoemthing(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", e1.getText().toString());
        startActivity(intent);
    }

}
