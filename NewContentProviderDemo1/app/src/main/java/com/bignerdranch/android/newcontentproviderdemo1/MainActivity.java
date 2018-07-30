package com.bignerdranch.android.newcontentproviderdemo1;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText1, mEditText2;
    private ContentValues mContentValues = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText1 = findViewById(R.id.edit1);
        mEditText2 = findViewById(R.id.edit2);
    }

    public void doSaveContent(View view) {
        mContentValues.put("employee_name", mEditText1.getText().toString());
        mContentValues.put("job_profile", mEditText2.getText().toString());

        Uri uri = getContentResolver().insert(CompanyContentProvider.CONTENT_URI, mContentValues);
        Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();

    }

    public void doLoadContent(View view) {
        Cursor cr = getContentResolver().query(CompanyContentProvider.CONTENT_URI, null, null, null, "_id");

        StringBuilder stringBuilder = new StringBuilder();

        while (cr.moveToNext()) {

            int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            stringBuilder.append(id + "    " + s1 + "      " + s2 + "\n");
        }
        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}
