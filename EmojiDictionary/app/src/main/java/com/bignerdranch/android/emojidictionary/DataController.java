package com.bignerdranch.android.emojidictionary;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataController {
    private static DataController sDataController;
    private List<Emoji> mEmojis;

    public static DataController getDataConroller() {
        if (sDataController == null) {
            sDataController = new DataController();
        }

        return sDataController;
    }

    private DataController() {
        mEmojis = new ArrayList<>();
        setupEmojis();
    }

    private void setupEmojis() {
        addEmoji(new Emoji("\uD83D\uDE00", "Grinning Face", "A typical grinning face"));
        addEmoji(new Emoji("\uD83D\uDC6E", "Police Officer", "A police officer"));
        addEmoji(new Emoji("\uD83D\uDC22", "Turtle", "A nice turtle"));
        addEmoji(new Emoji("\uD83C\uDF5D", "Spaghettti", "A plate of spaghetti"));
    }

    public void addEmoji(Emoji emoji) {
        mEmojis.add(emoji);
    }

    public void removeEmoji(Emoji emoji) {
        mEmojis.remove(emoji);
    }

    public void removeEmoji(int index) {
        mEmojis.remove(index);
    }

    public List<Emoji> getEmojis() {
        return mEmojis;
    }

    public Emoji getEmoji(int index) {
        return mEmojis.get(index);
    }

    public Emoji getEmoji(String symbol) {
        for (int index = 0; index < mEmojis.size(); index++) {
            Emoji tempEmoji = mEmojis.get(index);
            if (symbol.equals(tempEmoji.getSymbol())) {
                return tempEmoji;
            }
        }
        return null;
    }
}

