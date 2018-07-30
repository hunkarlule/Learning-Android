package com.bignerdranch.android.emojidictionary;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class EmojiActivity extends SingleFragmentActivity {

    public static final String TAG = "EmojiActivity";
    public  static final String EMOJI_SYMBOL = "Emoji_Symbol";

    @Override
    protected Fragment createFragment() {
        return new EmojiFragment();
    }

    public static Intent newIntent(Context context, String symbol) {
        Intent intent = new Intent(context, EmojiActivity.class);
        intent.putExtra(EMOJI_SYMBOL, symbol);
        return intent;

    }
}
