package com.bignerdranch.android.fragmentdemo3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    private TextView mTextViewResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container,false);
        mTextViewResult = view.findViewById(R.id.txvResult);

        return view;
    }

    public void addTwoNumbersInFragmentB(int x , int y) {

        int result = x + y;
        mTextViewResult.setText("Result: " + result);

    }
}
