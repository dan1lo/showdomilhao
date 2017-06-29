package DAO;
import java.io.Serializable;

import model.PerguntaModel;
import model.UserModel;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.Toast;

public class PerguntaPersistencia  {
	private Context context;
	private static PerguntaPersistencia  instance;
	private static SQLiteDatabase banco = null;
	Cursor cursor;
	
	public static PerguntaPersistencia getInstance(Context context){
		
		if (instance == null){
			
			instance = new PerguntaPersistencia(context);
		
			String sqlPerguntas = "CREATE TABLE IF NOT EXISTS perguntas "+
					"(id INTEGER PRIMARY KEY, pergunta TEXT, resposta1 TEXT,resposta2 TEXT,resposta3,"+
					" resposta4 TEXT, nivel INTEGER)";
			banco.execSQL(sqlPerguntas);
		}
		return instance;
	}
	
	public PerguntaPersistencia(Context context){
		this.context = context;
		}
	
	public PerguntaModel buscarPergunta(Context context, int id){
		
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
		PerguntaModel pergunta = new PerguntaModel(context);
		Cursor cursor = banco.query("perguntas", null, "id="+id, null, null, null, null);
		if(cursor.moveToFirst()){
			
			//ajeitar pergunta
			pergunta.setPergunta(cursor.getString(cursor.getColumnIndexOrThrow("pergunta")));
			pergunta.setResposta1(cursor.getString(cursor.getColumnIndexOrThrow("resposta1")));
			pergunta.setResposta2(cursor.getString(cursor.getColumnIndexOrThrow("resposta2")));
			pergunta.setResposta3(cursor.getString(cursor.getColumnIndexOrThrow("resposta3")));
			pergunta.setResposta4(cursor.getString(cursor.getColumnIndexOrThrow("resposta4")));
			
		}
		banco.close();
	
		return pergunta;
	}
	
	public int respostaCorreta(Context context, int id){
		banco = context.openOrCreateDatabase("showbilhao", Context.MODE_PRIVATE, null);
		PerguntaModel pergunta = new PerguntaModel(context);
		Cursor cursor = banco.query("perguntas", null, "id="+id, null, null, null, null);
		if(cursor.moveToFirst()){
			
			int valor = cursor.getInt(cursor.getColumnIndexOrThrow("nivel"));
			banco.close();
			return valor;
		}
		else {
			banco.close();	
			return 0;
		}
		
		
	}

}
