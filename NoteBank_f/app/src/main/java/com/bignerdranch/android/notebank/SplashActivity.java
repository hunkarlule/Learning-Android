package com.bignerdranch.android.notebank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

    public class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            Thread timer=new Thread()
            {
                public void run() {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    finally
                    {
                        Intent intent = new Intent(SplashActivity.this, NoteListActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            };
           timer.start();
        }
    }

