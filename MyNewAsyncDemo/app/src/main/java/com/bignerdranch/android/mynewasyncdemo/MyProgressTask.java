package com.bignerdranch.android.mynewasyncdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyProgressTask extends AsyncTask<Void, Integer, String> {
    Context mContext;
    ProgressDialog mProgressDialog;

    public MyProgressTask(Context context) {
        mContext = context;

    }

    @Override
    protected void onPreExecute() {
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setTitle("Downloading");
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setMax(10);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        mProgressDialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {

            try {
                for(int i = 1; i <= 10; i++) {
                    Thread.sleep(1000);
                    Log.i("Thread", "Execute" + i);
                    publishProgress(i);
                }
            } catch (InterruptedException e) {
                Log.i("Exception", e.getMessage());
                e.printStackTrace();
                return "failure";
            }

        return "Successful";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
         int myValue = values[0];
         mProgressDialog.setProgress(myValue);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(mContext,s, Toast.LENGTH_SHORT).show();
        mProgressDialog.dismiss();
        cancel(true);
    }
}
