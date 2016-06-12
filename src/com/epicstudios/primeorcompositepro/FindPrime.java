package com.epicstudios.primeorcompositepro;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.Intent;
import android.os.Bundle;

public class FindPrime extends ActionBarActivity {

	TextView numSearchedTextView, primeFoundTextView;
	Button submitButton;
	EditText findPrimeEditText;
	ImageButton backImageButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_prime);

		numSearchedTextView = (TextView)findViewById(R.id.numSearchedTextView);
		primeFoundTextView = (TextView)findViewById(R.id.primeFoundTextView);
		submitButton = (Button)findViewById(R.id.findPSubmitButton);
		findPrimeEditText = (EditText)findViewById(R.id.findPEditText);
		backImageButton = (ImageButton)findViewById(R.id.backImageButton);
		BackButtonListener();
		SubmitButton();
		
	}

	private void SubmitButton() {

		submitButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				int num = 0;
				
				try{
					num = Integer.valueOf(findPrimeEditText.getText().toString());
				}catch(Exception e){}
				
				FindPrime(num);
				
				findPrimeEditText.setText("");
				
			}

			private void FindPrime(int lookingForNum) {

				int numOfPrimes = 0;
				int primeFound = 0;
				
				for(int numOn = 0; numOfPrimes != lookingForNum; numOn++){
					if(Check(numOn) == 1){
						numOfPrimes ++;
					}
					if(numOfPrimes == lookingForNum){
						primeFound = numOn;
					}
				}
				
				numSearchedTextView.setText("Number Searched: " + lookingForNum);
				primeFoundTextView.setText("Prime Found: " + primeFound);
				
			}

			private int Check(int numOn) {

				int factors = 0;
				
				for(int i = 1; i <= numOn; i++){
					
					if(numOn%i==0){
						factors++;
					}
					
				}
				
				if(factors == 2){
					return 1;
				}else{
					return 0;
				}
				
			}
			
		});
		
	}
	
	private void BackButtonListener() {

		backImageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				Intent go = new Intent(v.getContext(), ChooseCalc.class);
				startActivity(go);
				
			}
			
		});
		
	}
}
