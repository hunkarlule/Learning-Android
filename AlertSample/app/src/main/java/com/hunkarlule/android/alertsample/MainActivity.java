package com.hunkarlule.android.alertsample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        myAlertBuilder.setTitle(R.string.alert_title);
        myAlertBuilder.setMessage(R.string.alert_message);
        myAlertBuilder.setPositiveButton("OK",this);
        myAlertBuilder.setNegativeButton("Cancel",this);
        myAlertBuilder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch(which) {
            case BUTTON_POSITIVE :
                Toast.makeText(getApplicationContext(), "Pressed OK!!!!", Toast.LENGTH_SHORT).show();
            case BUTTON_NEGATIVE:
                Toast.makeText(getApplicationContext(), "Pressed CANCEL!!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
