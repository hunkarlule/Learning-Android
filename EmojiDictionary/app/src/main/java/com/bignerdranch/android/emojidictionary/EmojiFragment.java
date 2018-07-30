package com.bignerdranch.android.emojidictionary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class EmojiFragment extends Fragment {
    public static final String TAG = "EmojiFragment";

    private Emoji emoji;
    private EditText emojiSymbol;
    private EditText emojiName;
    private EditText emojiDescription;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String symbol = (String) getActivity().getIntent().getSerializableExtra(EmojiActivity.EMOJI_SYMBOL);

        emoji = DataController.getDataConroller().getEmoji(symbol);
        Log.d(TAG, "OnCreate() called");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emoji, container, false);
        emojiSymbol = view.findViewById(R.id.emoji_symbol);
        emojiName = view.findViewById(R.id.emoji_name);
        emojiDescription = view.findViewById(R.id.emoji_description);
        Log.d(TAG, "OnCreateView() called");

        updateViews();
        return view;
    }

    private void updateViews() {
        emojiSymbol.setText(emoji.getSymbol());
        emojiName.setText(emoji.getName());
        emojiDescription.setText(emoji.getDescription());
    }
}
