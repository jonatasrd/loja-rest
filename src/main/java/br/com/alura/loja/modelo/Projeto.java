package br.com.alura.loja.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Projeto {

	private long id;
	private String nome;
	private int anoDeInicio;
	
	Projeto(){
		
	}
	
	public Projeto(long id, String nome, int ano){
		this.id = id;
		this.nome = nome;
		this.anoDeInicio = ano;
	}
	
	
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String toXML() {
		return  new XStream().toXML(this);
	}

	public String toJSon() {
		return new Gson().toJson(this);
	}
	
	
}