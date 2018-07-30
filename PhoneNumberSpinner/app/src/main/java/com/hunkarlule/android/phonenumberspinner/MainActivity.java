package com.hunkarlule.android.phonenumberspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mEditText;
    private Spinner mSpinner;
    private String mSpinnerLabel;
    private TextView mPhoneNumberResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText_main);
        mSpinner = findViewById(R.id.label_spinner);
        mPhoneNumberResult = findViewById(R.id.text_phonelabel);
        if (mSpinner != null) {
            mSpinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (mSpinner != null) {
            mSpinner.setAdapter(adapter);
        }
    }

    public void showText(View view) {
        if (mEditText != null) {
            String showString = mEditText.getText().toString() + " - " + mSpinnerLabel;
            if (mPhoneNumberResult != null) {
                mPhoneNumberResult.setText(showString);
                Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        mSpinnerLabel = adapterView.getItemAtPosition(position).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "onNothingSelected: ");
    }
}
