package com.bignerdranch.android.fragmentdemo1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();
    private Button mAddButton;
    private TextView mResultTextView;
    private int firstNumber = 0, secondNumber = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_a, container, false);

//        Bundle bundle = getArguments();
//
//        final int firstNumber = bundle.getInt(Constants.FIRST_NUMBER, 0);
//        final int secondNumber = bundle.getInt(Constants.SECOND_NUMBER, 0);

        mAddButton = view.findViewById(R.id.btnAdd);
        mResultTextView = view.findViewById(R.id.txvResult);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTwonumbers(firstNumber, secondNumber);
            }
        });
        return view;
    }

    private void addTwonumbers(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        mResultTextView.setText("Result: " + result);

    }

    public void setData(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

}
