package br.com.cadastro.model;


public class Cadastro {
	

	private Long id;
	private String login;
	private String sexo;
	private String nome;
	private String descricao;
	private Long idCadastroUsuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public void setIdCadastroUsuario(Long idCadastroUsuario) {
		this.idCadastroUsuario = idCadastroUsuario;
	}
	


}