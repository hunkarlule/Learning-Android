package com.pluralsight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.i("MyActivity", "onCreate");

        String createTime =
                (new SimpleDateFormat("HH:mm:ss")).format(System.currentTimeMillis());
        TextView textView = (TextView) findViewById(R.id.mainTextView);
        textView.setText("Created:" + createTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater() ;
        inflater.inflate(R.menu.main_menu, menu) ;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuShowOtherActivity:
                showOtherActivity();
                break;
            case R.id.menuRunService:
                runService();
                break;
            case R.id.menuQuit:
                finish();
                break;
            default:
                super.onOptionsItemSelected(item);
                break;
        }

        return true;
    }

    public void showOtherActivity()
    {
    }

    public void runService(){
    }
}
