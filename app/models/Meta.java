package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="META")
public class Meta{
	
	@Id @GeneratedValue
	@Column( name = "id")
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	

	@Column(name = "nsemana")
    public int nsemana;
	
	public String getdescricao() {
		return descricao;
	}
	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getsemana() {
		return nsemana;
	}
	public void setnSemana(int nSemana) {
		this.nsemana = nSemana;
	}
	public Long getId(){
		return id;
	}
			
	public int compareTo(Meta outraMeta){
		return this.getsemana() - outraMeta.getsemana();
		
	}

}
