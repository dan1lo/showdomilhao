package DAO;
import java.util.ArrayList;

import model.UserModel;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

public class UserPersistencia {
	private Context context;
	private static UserPersistencia instance;
	private static SQLiteDatabase banco = null;
	Cursor cursor;
	
	public UserPersistencia getInstance(Context context){
		
		if (instance == null){
			
			instance = new UserPersistencia(context);
			banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
			String sqlUser = "CREATE TABLE IF NOT EXISTS user "+
					"(id INTEGER PRIMARY KEY, nome TEXT)";
			banco.execSQL(sqlUser);
	
		}
		banco.close();
		return instance;
	}
	
	public UserPersistencia(Context context){
		this.context = context;
		}
	
	public void inserirUser(UserModel user) {
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null); 
		ContentValues value = new ContentValues();
		value.put("nome", user.getNome());
		banco.insert("user", null, value);  
		banco.close();
	}
	public void UpdateUser(UserModel user) {
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
		
		ContentValues value = new ContentValues();
		String[] id_string = new String[]{ String.valueOf(user.getId())};
		value.put("nome", user.getNome());
		banco.update("user", value, "id=?", id_string);
		banco.close();
		
	}
	public void deletarUser(int id){
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
		String[] id_string = new String[]{ String.valueOf(id)};
		banco.delete("user","id=?", id_string);
		banco.close();
		
	}
	public UserModel buscarUserId(Context context,int id){
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
		UserModel user = new UserModel(context);
		Cursor cursor = banco.query("user", null, "id="+id,null, null, null, null);
		if(cursor.moveToFirst()){
			user.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
			user.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
		}
		banco.close();
		return user;
	}
	
	public UserModel buscarUserNome(Context context, String nome){
		
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
		UserModel user = new UserModel(context);
		Cursor cursor = banco.query("user", null, "nome="+nome, null, null, null, null);
		if(cursor.moveToFirst()){
			user.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
			user.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
		}
		banco.close();
	
		return user;
	}
	
	public long quantosUser(Context context){
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
		Cursor c1 = banco.rawQuery("SELECT * FROM user", null);

		long count = c1.getCount(); 
		 banco.close();
		 return count;
		
	
	
	
	
	}
	public ArrayList<UserModel> getAllUsers(Context context){
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
	           
	      ArrayList<UserModel> usersList = new ArrayList<UserModel>();

	      Cursor cursor = banco.query("user", null, null, null, null, null, null);

	      while (cursor.moveToNext()) {
	    	  	UserModel user = new UserModel(context);
				user.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
				user.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
	            usersList.add(user);
	      }
	
	      banco.close();
	      return usersList;
	    
	  }
	
	
	
}
