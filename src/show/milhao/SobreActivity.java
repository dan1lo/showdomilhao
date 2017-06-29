package show.milhao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SobreActivity extends Activity {
	TextView lbl_sobre;
	@Override
	  public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
		setContentView(R.layout.sobre);
		lbl_sobre = (TextView) findViewById(R.id.lbl_sobre);
		lbl_sobre.setText("Jogo desenvolvido por Danilo Monteiro");
		
	  } 

}
