package model;

import android.content.Context;
import DAO.UserPersistencia;

public class UserModel {
	Context context;
	String nome;
	int id;
	public UserModel(Context context) {
		 
		this.context = context;
	}

	public void setNome(String nomeUser){
		 if (nomeUser!=""){
		this.nome = nomeUser;
		
		 	}else{
		 		this.nome = "Nome Desconhecido";
		 	}
		 		
		 }
	 
	 public String getNome(){
		 return nome;
	 }
	 
	 public int getId(){
		  
		 return id;
	 }
	 public void setId(int id){
		 this.id= id;
	 }
	
	
	   
}
