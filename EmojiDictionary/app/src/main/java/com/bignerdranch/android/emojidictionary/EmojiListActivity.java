package com.bignerdranch.android.emojidictionary;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class EmojiListActivity extends SingleFragmentActivity {
    public static final String TAG = "EmojiActivityList";


    @Override
    protected Fragment createFragment() {
        return new EmojiListFragment();
    }
}