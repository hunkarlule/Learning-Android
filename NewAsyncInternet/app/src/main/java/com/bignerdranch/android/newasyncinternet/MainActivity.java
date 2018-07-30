package com.bignerdranch.android.newasyncinternet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ConnectInternetTask mConnectInternetTask;
    private DownloadImageTask mDownloadImageTask;
    public static TextView sTextView;
    public static ImageView sImageView;

    ConnectivityManager mConnectivityManager;
    NetworkInfo mNetworkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sTextView = findViewById(R.id.myresult);
        sImageView = findViewById(R.id.myimageresult);

        mConnectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

    }

    public void doSomething(View view) {
        mConnectInternetTask = new ConnectInternetTask(this);
        mConnectInternetTask.execute("http://www.google.com");
    }

    public void downloadImage(View view) {
         if(mNetworkInfo != null && mNetworkInfo.isConnected()) {
             mDownloadImageTask = new DownloadImageTask();
             mDownloadImageTask.execute("https://wallpaper.wiki/wp-content/uploads/2017/04/wallpaper.wiki-Cool-Android-Images-Download-Free-PIC-WPD0010623.jpg");
         }
         else{
             Toast.makeText(this, "internet not connected", Toast.LENGTH_SHORT).show();
         }
    }
}
