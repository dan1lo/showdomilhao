package show.milhao;

import java.util.ArrayList;

import model.PerguntaModel;
import model.PerguntaUsadas;
import model.UserModel;
import DAO.PerguntaPersistencia;
import DAO.UserPersistencia;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PerguntaActivity extends Activity {
	TextView lbl_pergunta;
	TextView lbl_resposta1;
	TextView lbl_resposta2;
	TextView lbl_resposta3;
	TextView lbl_resposta4;
	Button btn_resposta1;
	Button btn_resposta2;
	Button btn_resposta3;
	Button btn_resposta4;
	PerguntaUsadas idUsadas;// = new PerguntaUsadas(getApplicationContext());
	@Override
	  public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        idUsadas = (PerguntaUsadas)getIntent().getExtras().getParcelable("idUsadas"); 
        ArrayList<Integer> id;
		id = idUsadas.getIdUsadas();
		
		PerguntaModel pergunta = new PerguntaModel(getApplicationContext());
		PerguntaPersistencia perguntaBD = new PerguntaPersistencia(getApplicationContext());
		Intent intentNum = getIntent();
		int num = intentNum.getIntExtra("num", 0);
		Toast.makeText(getApplicationContext(), " "+num, Toast.LENGTH_LONG).show();
		if (num ==10){
			
			Toast.makeText(getApplicationContext(), "Você Acertou as 10 perguntas, Párabens", Toast.LENGTH_LONG).show();
			Intent intet= new Intent("NovoJogoActivity");
        	startActivity(intet);
			
		}
		setContentView(R.layout.pergunta);
		
		int i = 0;
		while (i==0){
			int i2 = (int)(Math.random()*30);
			if (id.contains(i2)){
				i2 = 0 ;
			}
			idUsadas.setIdUsadas(i2);
			i=i2;
		}
		String numero;
		final int num2=num;
		numero = Integer.toString(i);
		pergunta = perguntaBD.buscarPergunta(getApplicationContext(), i);

		lbl_pergunta = (TextView) findViewById(R.id.lbl_pergunta);
		
		lbl_resposta1 = (TextView) findViewById(R.id.lbl_resposta1);
		lbl_resposta2 = (TextView) findViewById(R.id.lbl_resposta2);
		lbl_resposta3 = (TextView) findViewById(R.id.lbl_resposta3);
		lbl_resposta4 = (TextView) findViewById(R.id.lbl_resposta4);
		
		btn_resposta1 = (Button) findViewById(R.id.btn_resposta1);
		btn_resposta2 = (Button) findViewById(R.id.btn_resposta2);
		btn_resposta3 = (Button) findViewById(R.id.btn_resposta3);
		btn_resposta4 = (Button) findViewById(R.id.btn_resposta4);
		
		
		lbl_pergunta.setText(pergunta.getPergunta());
		lbl_resposta1.setText(pergunta.getResposta1());
		lbl_resposta2.setText(pergunta.getResposta2());
		lbl_resposta3.setText(pergunta.getResposta3());
		lbl_resposta4.setText(pergunta.getResposta4());
		
		final Context mContext = this;
		
		final int numPergunta = i;
		btn_resposta1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
						
					AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
					builder.setMessage("Você está certo disso?");
					builder.setCancelable(false);
					       builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
					    	   PerguntaPersistencia perguntaBD2 = new PerguntaPersistencia(getApplicationContext());
					    	   int valor = perguntaBD2.respostaCorreta(getApplicationContext(), numPergunta);
					           public void onClick(DialogInterface dialog, int id) {
					        	   if (valor==1){
					        		   
					        		   //Toast.makeText(getApplicationContext(), "Você acertou!", Toast.LENGTH_LONG).show();
					        		   Intent intent = new Intent(getApplicationContext(),PerguntaActivity.class);
					   	        		intent.putExtra("idUsadas", idUsadas);
					   	        		intent.putExtra("num", num2+1);
					   	        		startActivity(intent);
					        	   }
					        		   else{
					        			   
					        			Toast.makeText(getApplicationContext(), "Você Errou! Você teve um total de "+num2+ "perguntas certas", Toast.LENGTH_LONG).show();
					        			Intent intet= new Intent("FinalJogoActivity");
					        			 intet.putExtra("acertos", num2);
					        			startActivity(intet);
					   				}  
					        	   
					        	   
					        	   }
					       })
					       .setNegativeButton("Não", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					                dialog.cancel();
					           }
					       });
					builder.show();       
				}
				
			
		});
		
		btn_resposta2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
		
					
				AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
				builder.setMessage("Você está certo disso?");
				builder.setCancelable(false);
				       builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
				    	   PerguntaPersistencia perguntaBD2 = new PerguntaPersistencia(getApplicationContext());
				    	   int valor = perguntaBD2.respostaCorreta(getApplicationContext(), numPergunta);
				           public void onClick(DialogInterface dialog, int id) {
				        	   if (valor==2){
				        		   
				        		   Toast.makeText(getApplicationContext(), "Você acertou!", Toast.LENGTH_LONG).show();
				        		   	Intent intent= new Intent("PerguntaActivity");
				        		   	intent.putExtra("idUsadas", idUsadas);
				        		   	intent.putExtra("num", num2+1);
				   	        		startActivity(intent);
				        	   }
				        		   else{
				        			   
				        			   Toast.makeText(getApplicationContext(), "Você Errou! Você teve um total de "+num2+ "perguntas certas", Toast.LENGTH_LONG).show();
				        			Intent intet= new Intent("FinalJogoActivity");
				        			 intet.putExtra("acertos", num2);
				        			startActivity(intet);
				   				}  
				        	   
				        	   }
				       })
				       .setNegativeButton("Não", new DialogInterface.OnClickListener() {
				           public void onClick(DialogInterface dialog, int id) {
				                dialog.cancel();
				           }
				       });
				builder.show();       
			}
				
			
		});
	
btn_resposta3.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {

			
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		builder.setMessage("Você está certo disso?");
		builder.setCancelable(false);
		       builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
		    	   PerguntaPersistencia perguntaBD2 = new PerguntaPersistencia(getApplicationContext());
		    	   int valor = perguntaBD2.respostaCorreta(getApplicationContext(), numPergunta);
		           public void onClick(DialogInterface dialog, int id) {
		        	   if (valor==3){
		        		   
		        		   Toast.makeText(getApplicationContext(), "Você acertou!", Toast.LENGTH_LONG).show();
		        		   	Intent intent= new Intent("PerguntaActivity");
		        		   	intent.putExtra("idUsadas", idUsadas);
		        		   	intent.putExtra("num", num2+1);
		        		   	startActivity(intent);
		        	   }
		        		   else{
		        			   
		        			   Toast.makeText(getApplicationContext(), "Você Errou! Você teve um total de "+num2+ "perguntas certas", Toast.LENGTH_LONG).show();
		        			Intent intent= new Intent("FinalJogoActivity");
		        			 intent.putExtra("acertos", num2);
		    	        	startActivity(intent);
		   				}  
		        	   
		        	   }
		       })
		       .setNegativeButton("Não", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
		builder.show();       
	}
		
	
});


btn_resposta4.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {

		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		builder.setMessage("Você está certo disso?");
		builder.setCancelable(false);
		       builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
		    	   PerguntaPersistencia perguntaBD2 = new PerguntaPersistencia(getApplicationContext());
		    	   int valor = perguntaBD2.respostaCorreta(getApplicationContext(), numPergunta);
		           public void onClick(DialogInterface dialog, int id) {
		        	   if (valor==4){
		        		   
		        		   Toast.makeText(getApplicationContext(), "Você acertou!", Toast.LENGTH_LONG).show();
		        		   	Intent intent= new Intent("PerguntaActivity");
		        		   	intent.putExtra("idUsadas", idUsadas);
		        		   	intent.putExtra("num", num2+1);
		        		   	startActivity(intent);
		        	   }
		        		   else{
		        			   
		        			   Toast.makeText(getApplicationContext(), "Você Errou! Você teve um total de "+num2+ "perguntas certas", Toast.LENGTH_LONG).show();
		        			Intent intet= new Intent("FinalJogoActivity");
		        			 intet.putExtra("acertos", num2);
		    	        	startActivity(intet);
		   				}  
		        	   
		        	   }
		       })
		       .setNegativeButton("Não", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
		builder.show();       
	}
	
});





	  }
	

}
