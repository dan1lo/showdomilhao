package model;

import java.io.Serializable;
import java.util.ArrayList;

import android.content.Context;

/**
 * @author danilo
 *
 */
public class PerguntaModel {
	/**
	 * 
	 */

	Context context;
	int id;
	String pergunta;
	String resposta1;
	String resposta2;
	String resposta3;
	String resposta4;
	int nivel;

	
	public PerguntaModel(Context context) {
		this.context = context;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta1() {
		return resposta1;
	}
	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
	}
	public String getResposta2() {
		return resposta2;
	}
	public void setResposta2(String resposta2) {
		this.resposta2 = resposta2;
	}
	public String getResposta3() {
		return resposta3;
	}
	public void setResposta3(String resposta3) {
		this.resposta3 = resposta3;
	}
	public String getResposta4() {
		return resposta4;
	}
	public void setResposta4(String resposta4) {
		this.resposta4 = resposta4;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	
	
	

}
