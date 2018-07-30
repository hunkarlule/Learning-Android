package com.bignerdranch.android.explicitintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
 private TextView txt1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt1 = findViewById(R.id.result);

        Bundle bundle = getIntent().getExtras();

        String s1 = bundle.getString("user");

        txt1.setText(s1);

    }
}
