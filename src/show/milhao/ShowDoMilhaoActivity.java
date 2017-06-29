package show.milhao;
import model.UserModel;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import DAO.*;
public class ShowDoMilhaoActivity extends Activity {
    /** Called when the activity is first created. */
    EditText edt_nome;
    Button btn_ok;
	 UserModel user;
	 UserPersistencia userBD;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userBD = new UserPersistencia(this);
        userBD.getInstance(this);
        long numberLines =userBD.quantosUser(this);
        super.onCreate(savedInstanceState);
		String teste = String.valueOf(numberLines);
		//
		// Verificar se essa classe é nescessária realmente, estou criando ela para direcionar um fluxo
		//poderia está já na principlaActivity e acabaria com o bug de voltar
		//
        if(numberLines>0){
        	Toast.makeText(this, teste,Toast.LENGTH_LONG).show();
        	Intent intent = new Intent("PrincipalActivity");
        	startActivity(intent);
        	
        }else{
        	Intent intet= new Intent("CadastroUserActivity");
        	startActivity(intet);
        	
        	
        }
        

        

        



    	

    }
}