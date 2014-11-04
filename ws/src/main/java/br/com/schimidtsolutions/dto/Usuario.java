package br.com.schimidtsolutions.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {

	@NotNull(message = "O nome não pode ser nulo!")
	private String nome;

	@NotNull(message = "A idade não pode ser nula!")
	private Double idade;

	public Usuario(String nome, Double idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public Usuario() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getIdade() {
		return idade;
	}

	public void setIdade(Double idade) {
		this.idade = idade;
	}
}
