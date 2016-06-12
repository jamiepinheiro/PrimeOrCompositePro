package com.epicstudios.primeorcompositepro;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class PrimeOrComposite extends ActionBarActivity {

	TextView numberTextView, pOrCTextView, numFactorsTextView;
	Button submitButton;
	EditText pOrCEditText;
	ImageButton backImageButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prime_or_composite);
		
		numberTextView = (TextView)findViewById(R.id.pOrCNumberTextView);
		pOrCTextView = (TextView)findViewById(R.id.pOrCAnswerTextView);
		numFactorsTextView = (TextView)findViewById(R.id.numOfFactorsTextView);
		submitButton = (Button)findViewById(R.id.submitButton);
		pOrCEditText = (EditText)findViewById(R.id.pOrCEditText);
		backImageButton = (ImageButton)findViewById(R.id.backImageButton);
		
		BackButtonListeners();
		SubmitButton();
		
	}

	private void SubmitButton() {

		submitButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				int num = 0;
				try{
					num = Integer.valueOf(pOrCEditText.getText().toString());
				}catch(Exception e){}
				
				PrimeOrComposite(num);

				
			}

			private void PrimeOrComposite(int num) {

				int factors = 0;
				
				for(int numOn = 1; numOn <= num; numOn++){
					
					if(num%numOn==0){
						factors++;
					}
					
				}
				
				if(factors > 2){
					pOrCTextView.setText("Prime Or Composite: Composite");
				}else if(factors == 2){
					pOrCTextView.setText("Prime Or Composite: Prime");
				}
				
				numberTextView.setText("Number: " + num);
				numFactorsTextView.setText("Number Of Factors: " + factors);
				
				pOrCEditText.setText("");
				
			}
			
		});
		
	}

	private void BackButtonListeners() {

		backImageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				Intent go = new Intent(v.getContext(), ChooseCalc.class);
				startActivity(go);
				
			}
			
		});
		
	}
	
}	