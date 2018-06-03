package com.stark.rubbishselect1;


import com.stark.mysql.connectmysql;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class wordActivity extends Activity {
	Button submit;
	EditText mEditText;
	String mstr;
	TextView textview1;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wordinput);
		submit=(Button)findViewById(R.id.submit);
        mEditText=(EditText)findViewById(R.id.meditText);
        textview1=(TextView)findViewById(R.id.textView1);
        
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						connectmysql connect=new connectmysql("Information","Rubbish");
						textview1.setText(connect.search("2"));
//						textview1.setText(connect.geterror());
					}
					
				});
			}
		});
        
        mEditText.addTextChangedListener(new TextWatcher(){


			public void beforeTextChanged(CharSequence s, int start,
					int count, int after) {
				// TODO Auto-generated method stub
				
			}


			public void onTextChanged(CharSequence s, int start,
					int before, int count) {
				// TODO Auto-generated method stub
				
			}


			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				submit.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						mstr=mEditText.getText().toString();
						if(mstr.equals("纸")){
							textview1.setText("凉凉");
						}
					}
				});
			}
	   });
    }

}

