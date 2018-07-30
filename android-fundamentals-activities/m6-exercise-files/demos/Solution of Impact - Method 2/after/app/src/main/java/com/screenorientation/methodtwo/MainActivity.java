package com.screenorientation.methodtwo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Demo App for Solution 2:
 * 		1. To prevent Activity from being destroyed and recreated on Screen Rotation
 * 		   So that we don't need to care about the View's values or data.
 * 		2. Here we need to manually update the resources (if any) inside onConfigurationChanged().
 * */
public class MainActivity extends AppCompatActivity {

	private final String TAG = MainActivity.class.getSimpleName();

	private TextView txvMessage;
	private EditText etName;
	private Button btnSubmit;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "onCreate()");

		etName = (EditText) findViewById(R.id.etName);
		txvMessage = (TextView) findViewById(R.id.txvMessage);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		imageView = (ImageView) findViewById(R.id.imageView);

		btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				txvMessage.setText("Welcome " + etName.getText().toString());
				btnSubmit.setText("LOGOUT");
			}
		});
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.i(TAG, "onConfigurationChanged()");

		if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			Toast.makeText(getApplicationContext(), "portrait", Toast.LENGTH_SHORT).show();
			imageView.setImageResource(R.drawable.portrait);
		} else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			Toast.makeText(getApplicationContext(), "landscape", Toast.LENGTH_SHORT).show();
			imageView.setImageResource(R.drawable.landscape);
		}
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart()");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy()");
	}
}
