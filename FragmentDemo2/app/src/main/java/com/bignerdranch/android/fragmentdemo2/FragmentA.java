package com.bignerdranch.android.fragmentdemo2;

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
import android.widget.EditText;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();
    private Button mSendButton;
    private EditText mEditTextFirstNumber;
    private EditText mEditTextSecondNumber;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        mEditTextFirstNumber = view.findViewById(R.id.etFirstNumber);
        mEditTextSecondNumber = view.findViewById(R.id.etSecondNumber);

        mSendButton = view.findViewById(R.id.btnSnd);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
        return view;
    }

    private void sendData() {
        int firtsNumber = Integer.valueOf(mEditTextFirstNumber.getText().toString());
        int secondNumber = Integer.valueOf(mEditTextSecondNumber.getText().toString());

        MyListener myListener = (MyListener) getActivity();
        myListener.addTwoNumbers(firtsNumber, secondNumber);
    }


}

