package com.example.java_android_assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.*;
import android.view.*;

public class Calculator extends Activity {
	
	private long total = 0l;
	private long current = 0l;
	private char operator = ' ';
	public static final long maxDigit = 100000000000000l;

	public void refreshText(){
		TextView t = (TextView)findViewById(R.id.textTotal);
		TextView c = (TextView)findViewById(R.id.textCurrent);
		TextView o = (TextView)findViewById(R.id.textOperator);
		String strTotal = "" + total;
		String strCurrent = "" + current;
		String strOperator = "" + operator;
 		t.setText(strTotal);
		c.setText(strCurrent);
		o.setText(strOperator);
	}
	
	private void addCurrent(int x){
		if(current % maxDigit == current){
			if(current == 0){
				current += x;
			}else if (current > 0){
				current = current * 10 + x;
			}else if (current < 0){
				current = current * 10 - x;
			}
		}
		
	}
	
	private void setNegation(){
		current = 0 - current;
	}
	
//	private void setOperation(char op){
//		operator = op;
//	}
	
	private void compute(View v, char op) {
		if(op != '+' && op != '-' && op != '=') {
			// Programmer error: wrong value for op.
			// Only ¡¯+¡¯ or ¡¯-¡¯ or ¡¯=¡¯ are allowed for op.
			Toast.makeText(v.getContext(),
			"Error! The compute method can only be called" +
			" with + or - or =, not with " + op,
			Toast.LENGTH_LONG).show();
				// Reset.
				total = 0;
				op = ' ';
		} else {
			switch(operator) {
				case '+':
					total += current;
					break;
				case '-':
					total -= current;
					break;
				case ' ':
				case '=': // = and ¡¯ ¡¯ behave like + 0
					total = current;
					break;
				default:
					// Programmer error: the operator instance variable was not
					// initialize correctly to ¡¯ ¡¯ at the start of the app or not
					// re-initialized correctly to ¡¯ ¡¯ during CA.
					Toast.makeText(v.getContext(),
					"Error! The operator instance variable must" +
					" be initialized to ¡¯ ¡¯, not: " + operator,
					Toast.LENGTH_LONG).show();
					// Reset.
					total = 0;
					op = ' ';
			}
		}
		current = 0;
		operator = op;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		refreshText();
		
		final Button btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn1.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn2 = (Button) findViewById(R.id.btn2);
		btn2.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn2.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn3 = (Button) findViewById(R.id.btn3);
		btn3.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn3.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn4 = (Button) findViewById(R.id.btn4);
		btn4.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn4.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn5 = (Button) findViewById(R.id.btn5);
		btn5.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn5.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn6 = (Button) findViewById(R.id.btn6);
		btn6.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn6.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn7 = (Button) findViewById(R.id.btn7);
		btn7.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn7.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn8 = (Button) findViewById(R.id.btn8);
		btn8.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn8.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn9 = (Button) findViewById(R.id.btn9);
		btn9.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn9.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btn0 = (Button) findViewById(R.id.btn0);
		btn0.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ButtonText = btn0.getText().toString();
				addCurrent(Integer.parseInt(ButtonText));
				refreshText();
			}
		});
		
		final Button btnNegation = (Button) findViewById(R.id.btnNegation);
		btnNegation.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				setNegation();
				refreshText();
			}
		});
		
		final Button btnPlus = (Button) findViewById(R.id.btnPlus);
		btnPlus.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				String ButtonText = btnPlus.getText().toString();
				compute(v, ButtonText.charAt(0));
				refreshText();
			}
		});
		
		final Button btnMinus = (Button) findViewById(R.id.btnMinus);
		btnMinus.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				String ButtonText = btnMinus.getText().toString();
				compute(v, ButtonText.charAt(0));
				refreshText();
			}
		});
		
		final Button btnEquals = (Button) findViewById(R.id.btnEquals);
		btnEquals.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				String ButtonText = btnEquals.getText().toString();
				compute(v, ButtonText.charAt(0));
				refreshText();
			}
		});
		
		final Button btnCA = (Button) findViewById(R.id.btnCA);
		btnCA.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				total = 0;
				current = 0;
				operator = ' ';
				refreshText();
			}
		});
		
		final Button btnCC = (Button) findViewById(R.id.btnCC);
		btnCC.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				current = 0;
				refreshText();
			}
		});
		
	}
}
