package com.hunkarlule.android.keyboardsamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText_main);
    }

    public void showText(View view) {
      if(mEditText != null) {
          String showString = mEditText.getText().toString();
          Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
      }
    }
}
