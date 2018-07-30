package com.bignerdranch.android.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mSubmitButton;
    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmitButton = findViewById(R.id.submitBtn);
        mNameEditText = findViewById(R.id.nameEditText);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //moveToSecondActivity_FirstWay();
                moveToSecondActivity_SecondWay();
            }
        });
    }

    private void moveToSecondActivity_FirstWay() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_NAME, mNameEditText.getText().toString());
        bundle.putInt(Constants.KEY_AGE, 37);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void moveToSecondActivity_SecondWay() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra( Constants.KEY_NAME, mNameEditText.getText().toString());
        intent.putExtra(Constants.KEY_AGE, 37);
        startActivity(intent);
    }
}
