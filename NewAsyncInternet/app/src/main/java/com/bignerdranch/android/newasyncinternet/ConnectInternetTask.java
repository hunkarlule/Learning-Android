package com.bignerdranch.android.newasyncinternet;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectInternetTask extends AsyncTask<String, Void, String> {

    private Context mContext;

    public ConnectInternetTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String s1 = strings[0];
        InputStream inputStream;

        try {
            URL myURL = new URL(s1);
            HttpURLConnection myConn = (HttpURLConnection) myURL.openConnection();
            myConn.setReadTimeout(10000);
            myConn.setConnectTimeout(20000);
            myConn.setRequestMethod("GET");
            myConn.connect();

            inputStream = myConn.getInputStream();

            BufferedReader myBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String line = "";

            while ((line = myBufferedReader.readLine()) != null) {
                stringBuilder.append(line + " \n");
            }
            myBufferedReader.close();
            inputStream.close();

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        MainActivity.sTextView.setText(s);
    }
}
