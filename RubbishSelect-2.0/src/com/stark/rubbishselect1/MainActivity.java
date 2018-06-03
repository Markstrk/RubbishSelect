package com.stark.rubbishselect1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button word;
	Button scan;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        word=(Button)findViewById(R.id.word);
        scan=(Button)findViewById(R.id.scan);


        
        word.setOnClickListener(new View.OnClickListener() {
			

			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent wordIntent=new Intent();
				wordIntent.setClass(MainActivity.this, wordActivity.class);
				startActivity(wordIntent);
				
				}
			});
        
        scan.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent scanIntent=new Intent();
				scanIntent.setClass(MainActivity.this, scanActivity.class);
				startActivity(scanIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
