package show.milhao;

import model.UserModel;
import DAO.UserPersistencia;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUserActivity extends Activity {
    EditText edt_nome;
    Button btn_ok;
	 UserModel user;
	 UserPersistencia userBD;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
    	setContentView(R.layout.cadastrouser);
		userBD = new UserPersistencia(getApplicationContext());
          edt_nome = (EditText) findViewById(R.id.edt_nome);
          final Button button = (Button) findViewById(R.id.btn_cadastrar);
  				button.setOnClickListener(new View.OnClickListener() {
  				public void onClick(View v) {
              	user = new UserModel(getApplicationContext());
              	String nome = edt_nome.getText().toString();
                  user.setNome(nome);
  				userBD.inserirUser(user);
  				 Toast.makeText(getApplicationContext(), "Usuário Cadastrado com sucesso",Toast.LENGTH_LONG).show();
  				 Intent it = new Intent("NovoJogoActivity");
  				 startActivity(it);
  		         }
  	           });
  	        	
  	        }
  	        
    }


