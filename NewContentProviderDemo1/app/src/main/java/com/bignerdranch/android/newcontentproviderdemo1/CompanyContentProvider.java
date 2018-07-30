package com.bignerdranch.android.newcontentproviderdemo1;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class CompanyContentProvider extends ContentProvider {

    private SQLiteDatabase mSQLiteDatabase;


    public static final String AUTHORITY = "com.bignerdranch.company.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/eployee");

    private static final String DB_NAME = "company";
    private static final String DB_TABLE_NAME = "employee";
    private static final int DB_VERSION = 1;

    public static final int EMP = 1;
    public static final int EMP_ID = 2;

    static UriMatcher myUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        myUriMatcher.addURI(AUTHORITY, "employee", EMP);
        myUriMatcher.addURI(AUTHORITY, "employee/#", EMP_ID);
    }

    public CompanyContentProvider() {
    }

    private class MyOwnDatabase extends SQLiteOpenHelper {

        public MyOwnDatabase(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + DB_TABLE_NAME + " (_id integer primary key autoincrement, employee_name text, job_profile text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + DB_TABLE_NAME);
        }
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long row = mSQLiteDatabase.insert(DB_TABLE_NAME, null, values);
        if (row > 0) {
            uri = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return uri;
    }

    @Override
    public boolean onCreate() {
        MyOwnDatabase myOwnDatabase = new MyOwnDatabase(getContext());
        mSQLiteDatabase = myOwnDatabase.getWritableDatabase();
        if (mSQLiteDatabase != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder myQuery = new SQLiteQueryBuilder();
        myQuery.setTables(DB_TABLE_NAME);
        Cursor myCursor = myQuery.query(mSQLiteDatabase, null, null, null, null, null, "_id");
        myCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return myCursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
