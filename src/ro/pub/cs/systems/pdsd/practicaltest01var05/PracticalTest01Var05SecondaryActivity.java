package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
		
		Intent intent = getIntent();
		
		TextView num 	= (TextView) findViewById(R.id.num);
		TextView coords	= (TextView) findViewById(R.id.coords);
		
		String newCoords 	= 	intent.getStringExtra("coords");
		final Integer countCoords	=	intent.getIntExtra("count", 0);
		
		coords.append(newCoords);
		num.append(countCoords.toString());
		
		Button reg 		= (Button) findViewById(R.id.register);
		Button cancel 	= (Button) findViewById(R.id.cancel);
		
		reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// intent to parent
				  Intent intentToParent = new Intent();
				  setResult(RESULT_OK, intentToParent);
				  finish();
				
			}
		});

		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentToParent = new Intent();
				  setResult(RESULT_CANCELED, intentToParent);
				  finish();
			}
		});
	}
}
