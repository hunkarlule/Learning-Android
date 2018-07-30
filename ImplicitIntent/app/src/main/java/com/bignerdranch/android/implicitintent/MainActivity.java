package com.bignerdranch.android.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View view) {

        switch (view.getId()) {
            case R.id.b1:
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http:// google.com"));
                startActivity(intent1);
                break;

            case R.id.b2:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6048079956"));
                startActivity(intent2);
                break;

            case R.id.b3:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.9637,35.2433"));
                startActivity(intent3);
                break;
        }
    }
}
