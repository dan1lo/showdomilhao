package show.milhao;

import java.util.ArrayList;
import java.util.Iterator;

import model.PerguntaModel;
import model.PerguntaUsadas;
import model.UserModel;

import DAO.UserPersistencia;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NovoJogoActivity extends Activity {
	Spinner spn_usuario;
	Button btn_novo;
	UserPersistencia userDB;

	@Override
	  public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
		setContentView(R.layout.novojogo);
		spn_usuario = (Spinner)findViewById(R.id.spn_usuario);
		ArrayList<UserModel> userList = new ArrayList<UserModel>();
		userDB = new UserPersistencia(getApplicationContext());
		userList = userDB.getAllUsers(getApplicationContext());	
		ArrayList<String> nomes = new ArrayList<String>();
		UserModel user;
		nomes.add("Escolha um usuário");
		for (Iterator<UserModel> iterator = userList.iterator(); iterator.hasNext(); ) {  
		
		user = (UserModel) iterator.next();	
		//user = (UserModel)userList.get(0);		
		//Toast.makeText(this, user.getNome(),Toast.LENGTH_LONG).show();
		nomes.add(user.getNome());
		}
		ArrayAdapter<String> adpater = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, nomes);
		spn_usuario.setAdapter(adpater);
		btn_novo = (Button) findViewById(R.id.btn_novoUser);
		
	

		
		btn_novo.setOnClickListener(new View.OnClickListener() {
		/*
		 * 
		 * 	(non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
			public void onClick(View v) {
	     
	        	Intent intet= new Intent("CadastroUserActivity");
	        	startActivity(intet);
	        	finish();
			}
		});
		
		spn_usuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	        public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
	        	
	        	
	        	String str =(String) spn_usuario.getSelectedItem();
	        	if(posicao==0){
	        		
	        	}else{
	        	Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
	        	PerguntaUsadas idUsadas = new PerguntaUsadas(getApplication());
	        	//Intent intent= new Intent("PerguntaActivity");
	        	Intent intent = new Intent(getApplicationContext(),PerguntaActivity.class);
	        	intent.putExtra("idUsadas", idUsadas);
	        	intent.putExtra("num", 0);
	        	startActivity(intent);
	        	finish();
	        	
	        	}
	        }//Fim do método onItemSelected()

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	              
	       
	    } );//Fim do método setOnItemSelectedListener()
	  } 
	
	

}
