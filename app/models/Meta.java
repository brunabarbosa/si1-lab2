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

	public String getNome() {
		return nome;
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

	public int compareTo(Meta outraMeta) {
		return this.getsemana() - outraMeta.getsemana();

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
