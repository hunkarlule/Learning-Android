package com.sriyanksiddhartha.eventhandlingmethod2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Method 2: Event Handling using Buttons inside the Activity.
 */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);

		// new View.OnClickListener() {...} - It refers to an Object that implements an interface.
		assert button1 != null;
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				assert relativeLayout != null;
				relativeLayout.setBackgroundColor(Color.GREEN);
			}
		});

		assert button2 != null;
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				assert relativeLayout != null;
				relativeLayout.setBackgroundColor(Color.BLUE);
			}
		});
	}
}
