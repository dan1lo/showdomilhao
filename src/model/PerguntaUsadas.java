package model;

import java.io.Serializable;
import java.util.ArrayList;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class PerguntaUsadas implements Parcelable {
	Context context;
	/**
	 * 
	 */
	int id;
	int num;
	public static ArrayList<Integer> idUsadas = new ArrayList<Integer>();
	public void setIdUsadas(int id){
		idUsadas.add(id);		
		
	}
	 public static final Parcelable.Creator<PerguntaUsadas>  
	   CREATOR = new Parcelable.Creator<PerguntaUsadas>() {  
	  
	   public PerguntaUsadas createFromParcel(Parcel in) {  
	     return new PerguntaUsadas(in);  
	   }  
	  
	   public PerguntaUsadas[] newArray(int size) {  
	     return new PerguntaUsadas[size];  
	   }  
	 };
	 private PerguntaUsadas(Parcel p){  
		   //idUsadas = from.readInt();  
		 
		 }  
	public ArrayList<Integer> getIdUsadas(){
		
		return idUsadas ;
	}
	public PerguntaUsadas (Context context){
		this.context=context;
	}
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void writeToParcel(Parcel dest, int arg1) {
		// TODO Auto-generated method stub

	}
	public int numero(){
		this.num= num+1;
		return this.num;
	}
}
