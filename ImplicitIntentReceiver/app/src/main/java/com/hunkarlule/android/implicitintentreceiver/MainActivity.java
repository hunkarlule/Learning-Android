package com.hunkarlule.android.implicitintentreceiver;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text_uri_message);
        Intent intent = getIntent();
        Uri uri = intent.getData();

        if (uri != null) {
            String uriString = "URI: " + uri.toString();
            mTextView.setText(uriString);

        }
    }
}
