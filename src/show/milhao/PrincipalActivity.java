package show.milhao;

import DAO.UserPersistencia;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrincipalActivity extends Activity{
	Button btn_novojogo;
	Button btn_opcao;
	Button btn_sobre;
	Button btn_rank; 
	UserPersistencia userDB;
	@Override
	  public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		btn_novojogo = (Button) findViewById(R.id.btn_novojogo);
		btn_opcao = (Button)findViewById(R.id.btn_opcao);
		btn_sobre = (Button)findViewById(R.id.btn_sobre);
		btn_rank = (Button)findViewById(R.id.btn_rank);
		
		
		//ação de clicar nos botoes
		btn_novojogo.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("NovoJogoActivity");
	        	startActivity(intent);
				
			}
			
			
		});
		
		btn_opcao.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("OpcoesActivity");
	        	startActivity(intent);
				
			}
		});
		
		btn_sobre.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("SobreActivity");
	        	startActivity(intent);
			}
		});
		
		btn_rank.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("RankActivity");
	        	startActivity(intent);
			}
		});
		
		
		// fim das ações de clicar no botao
	  }

}
