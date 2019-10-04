package br.com.cadastro.model;

import java.util.Calendar;

public class Cadastro {
	private Long id;
	private Calendar data_hora;
	private String nome;
	private String sexo;	
	private String descricao;
	private Long idCadastroUsuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getData_hora() {
		return data_hora;
	}
	public void setData_hora(Calendar data_hora) {
		this.data_hora = data_hora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getIdCadastroUsuario() {
		return idCadastroUsuario;
	}
	public void setIdCadastroUsuario() {
		Usuario usuario = new Usuario();
		this.idCadastroUsuario = usuario.getId();
	}
}
