package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "META")
public class Meta {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "nsemana")
	public int nsemana;

	@Column(name = "prioridade")
	private Prioridade prioridade;
	
	@Column(name = "concluida")
	private boolean concluida;
	
	public String getNome() {
		return nome;
	}
	
	public Meta(String nome, String descricao, int nsemana, Prioridade prioridade, boolean concluida){
		this.nome = nome;
		this.descricao = descricao;
		this.nsemana = nsemana;
		this.prioridade = prioridade;
		this.concluida = concluida;
	}
	
	public Meta(){
	
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getsemana() {
		return nsemana;
	}

	public void setnSemana(int nSemana) {
		this.nsemana = nSemana;
	}

	public Long getId() {
		return id;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public int compareTo(Meta outraMeta) {
		return this.getsemana() - outraMeta.getsemana();

	}

}
