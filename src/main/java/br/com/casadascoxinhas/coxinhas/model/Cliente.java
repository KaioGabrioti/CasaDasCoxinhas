package br.com.casadascoxinhas.coxinhas.model;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

public class Cliente {
	
	@Id
	@GeneratedValue
	private Integer id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	private Integer telefone;

	@NotBlank
	private Integer celular;
	
	private Integer CEP;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String Bairro;
	
	private String Complemento;
	
	@NotBlank
	private String Rua;
	
	@NotBlank
	private Integer numero;
	
	@NotBlank
	private Calendar dataNascimento;
	
	public Cliente(Integer id, String nome, String sobrenome, Integer telefone, Integer celular, Integer cEP,
			String cidade, String bairro, String complemento, String rua, Integer numero, Calendar dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.celular = celular;
		CEP = cEP;
		this.cidade = cidade;
		Bairro = bairro;
		Complemento = complemento;
		Rua = rua;
		this.numero = numero;
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public Integer getCEP() {
		return CEP;
	}

	public void setCEP(Integer cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
