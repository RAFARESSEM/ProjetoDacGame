package br.edu.ifpb.dac.projetogame.dto;

import br.edu.ifpb.dac.projetogame.model.entity.Peca;


public class TabuleiroDTO {
	
	private long id;
	private String nome;
	private Peca peca;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	


}
