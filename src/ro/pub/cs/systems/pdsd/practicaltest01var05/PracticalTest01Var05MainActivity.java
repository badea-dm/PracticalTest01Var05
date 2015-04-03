package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class PracticalTest01Var05MainActivity extends Activity {
	
	private int numCoords;
	
	public Intent intent;
	
	public void onSavedInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
		
		savedInstanceState.putInt("numCoords", numCoords);
	}
	
	public void onRestoreInstanceState(Bundle savedInstanceState){
		super.onRestoreInstanceState(savedInstanceState);
		
		numCoords = savedInstanceState.getInt("numCoords");
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		TextView coords = (TextView) findViewById(R.id.coords);
		
		coords.setText("");
		
		if (resultCode == RESULT_OK) {
			numCoords ++;
		}
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numCoords = 0;
        setContentView(R.layout.activity_practical_test01_var05_main);
        
        final Button north 	= (Button) findViewById(R.id.north);
        final Button south 	= (Button) findViewById(R.id.south);
        final Button east 	= (Button) findViewById(R.id.east);
        final Button west 	= (Button) findViewById(R.id.west);
        final Button send	= (Button) findViewById(R.id.next);
        
        intent = new Intent(this, PracticalTest01Var05SecondaryActivity.class);
        
        north.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView coords = (TextView) findViewById(R.id.coords);
				
				coords.append(north.getText().toString() + ' ');
				
			}
		});
        
        south.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView coords = (TextView) findViewById(R.id.coords);
				
				coords.append(south.getText().toString() + ' ');
				
			}
		}); 

		east.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView coords = (TextView) findViewById(R.id.coords);
				
				coords.append(east.getText().toString() + ' ');
				
			}
		});

		west.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView coords = (TextView) findViewById(R.id.coords);
				
				coords.append(west.getText().toString() + ' ');
				
			}
		});
		
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText text = (EditText) findViewById(R.id.coords);
				String message = text.getText().toString();
				
				intent.putExtra("coords", message);
				intent.putExtra("count", numCoords);
				
				int result = 5;
				
				startActivityForResult(intent, result);
				
			}
		});
    }
}
