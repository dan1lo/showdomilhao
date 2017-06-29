package DAO;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.Toast;

public class RankPersistencia {
	private Context context;
	private static RankPersistencia instance;
	private static SQLiteDatabase banco = null;
	Cursor cursor;
	
	public static RankPersistencia getInstance(Context context){
		
		if (instance == null){			
			instance = new RankPersistencia(context);
			banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
			String sqlRank = "CREATE TABLE IF NOT EXISTS rank "+
					"(id INTEGER PRIMARY KEY, rank INTEGER, tempo INTEGER, id_user INTEGER)";
			
			banco.execSQL(sqlRank);
			
		}
		return instance;
	}
	
	private RankPersistencia(Context context){
		this.context = context;
		}

}
