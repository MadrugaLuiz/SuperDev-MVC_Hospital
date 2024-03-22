package br.com.projetoMVC.model;

public class Paciente {

	private int id;
	private String nome;
	private String cpf;
	private int idade;

	public Paciente() {

	}

	public Paciente(int id, String nome, String cpf, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}

	public int getId() {
		return id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf = cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade = idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
