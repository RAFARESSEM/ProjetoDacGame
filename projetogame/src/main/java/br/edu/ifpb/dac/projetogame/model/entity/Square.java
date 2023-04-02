package br.edu.ifpb.dac.projetogame.model.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Tabuleiro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String nome;
	
	@OneToOne (fetch = FetchType.LAZY)
	private Peca peca;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	
	public Tabuleiro(long id, String nome, Peca peca) {
		super();
		this.id = id;
		this.nome = nome;
		this.peca = peca;
	}
	
	public Tabuleiro() {
		
	}
	@Override
	public String toString() {
		return "Tabuleiro [id=" + id + ", nome=" + nome + ", peca=" + peca.getClasse() + "]";
	}
	

}
