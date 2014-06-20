package models;

public enum Prioridade {

	Baixa(1), Media(2), Alta(3);
	
	private int valor;
	
	Prioridade(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return valor;
	}
	
	
}
