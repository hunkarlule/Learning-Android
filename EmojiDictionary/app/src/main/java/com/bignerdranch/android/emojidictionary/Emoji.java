package com.bignerdranch.android.emojidictionary;

public class Emoji {
    private String mSymbol;
    private String mName;
    private String mDescription;

    public Emoji(String symbol, String name, String description) {
        setSymbol(symbol);
        setName(name);
        setDescription(description);
    }

    public Emoji() {
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        this.mSymbol = symbol;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    @Override
    public String toString() {
        return "Emoji{" +
                "mSymbol='" + mSymbol + '\'' +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }
}
