package com.sriyanksiddhartha.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

	private static final String TAG = FragmentA.class.getSimpleName();

	private Button btnAdd;
	private TextView txvResult;
	private int firstNumber = 0;
	private int secondNumber = 0;

	private MainActivity.Employee employee;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_a, container, false);

		txvResult = (TextView) view.findViewById(R.id.txvResult);

		btnAdd = (Button) view.findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				addTwoNumbers(firstNumber, secondNumber);
			}
		});

		return view;
	}

	private void addTwoNumbers(int firstNumber, int secondNumber) {

		int result = firstNumber + secondNumber;
		txvResult.setText("Result : " + result);
	}

	public void setData(int firstNumber, int secondNumber) {

		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void setEmployeeObj(MainActivity.Employee employee) {
		this.employee = employee;
	}
}
