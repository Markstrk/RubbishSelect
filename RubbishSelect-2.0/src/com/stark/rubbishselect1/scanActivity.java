package com.stark.rubbishselect1;

import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class scanActivity extends Activity {
	
	private TextView scanResult;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scan);
		scanResult=(TextView)findViewById(R.id.scanResult);
		Intent startScan=new Intent(this,CaptureActivity.class);
		startActivityForResult(startScan,0);
		
	}
	
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==-1)
		{
			String result=data.getExtras().getString("result");
			scanResult.setText(result);
		}
	}

}
