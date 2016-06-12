package com.epicstudios.primeorcompositepro;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class ChooseCalc extends ActionBarActivity {

	Button pOrCButton, findPButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_calc);

		pOrCButton = (Button)findViewById(R.id.pOrCButton);
		findPButton = (Button)findViewById(R.id.findPButton);
		
		Buttons();

	}

	private void Buttons() {

		pOrCButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent go = new Intent(v.getContext(), PrimeOrComposite.class);
				startActivity(go);
				
			}
			
		});
		
		findPButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent go = new Intent(v.getContext(), FindPrime.class);
				startActivity(go);
				
			}
			
		});
		
	}

}
