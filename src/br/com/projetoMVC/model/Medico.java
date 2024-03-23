package br.com.projetoMVC.model;

public class Medico {

	private int id;
	private String nome;
	private String especialidade;
	private String crm;
	private boolean isPlantao;

	public Medico() {

	}

	public Medico(int id, String nome, String especialidade, String crm, boolean isPlantao) {
		super();
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.crm = crm;
		this.isPlantao = isPlantao;
	}

	public int getId() {
		return id;
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

	public String getEspecialidade() {
		return especialidade = especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm = crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public boolean getIsPlantao() {
		return true;
	}

	public void setIsPlantao(boolean isPlantao) {
		this.isPlantao = isPlantao;
	}

}
