package show.milhao;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class FinalJogoActivity extends Activity {
	
	Button btn_facebook;
	Button btn_JogarNovamente;
	TextView lbl_acertos;
	RatingBar barra;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.finalperguntas);
		btn_facebook = (Button) findViewById(R.id.btn_facebook);
		btn_JogarNovamente = (Button) findViewById(R.id.btn_jogarNovamente);
		lbl_acertos = (TextView) findViewById(R.id.lbl_acertos);
		barra = (RatingBar) findViewById(R.id.ratingBar1);
		Intent intentNum = getIntent();
		int num = intentNum.getIntExtra("acertos", 0);
		lbl_acertos.setText(num+" Perguntas");
		
		btn_JogarNovamente.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent("NovoJogoActivity");
	        	startActivity(intent);				
			}
		});
		
		barra.setClickable(false);
		barra.setEnabled(false);
		if(num<=2){
			barra.setRating(1);
		}else if(num>2&&num<=4){
			barra.setRating(2);
		}else if(num>4&&num<=6){
			barra.setRating(3);
		}else if(num>6&&num<=8){
			barra.setRating(4);
		}else if(num>8&&num<=10){
			barra.setRating(5);
		}
		
		
	}

}
