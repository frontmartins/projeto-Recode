package model;

public class PacoteDeViagem {
private int id;
private String destino;
private String itinerario;
private float preco;
private String datasDisponiveis;
private String descricao;


public PacoteDeViagem() {
	super();
}


public PacoteDeViagem(String destino, String itinerario, float preco, String datasDisponiveis, String descricao) {
	super();
	this.destino = destino;
	this.itinerario = itinerario;
	this.preco = preco;
	this.datasDisponiveis = datasDisponiveis;
	this.descricao = descricao;
}


public PacoteDeViagem(int id, String destino, String itinerario, float preco, String datasDisponiveis,
		String descricao) {
	super();
	this.id = id;
	this.destino = destino;
	this.itinerario = itinerario;
	this.preco = preco;
	this.datasDisponiveis = datasDisponiveis;
	this.descricao = descricao;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getDestino() {
	return destino;
}


public void setDestino(String destino) {
	this.destino = destino;
}


public String getItinerario() {
	return itinerario;
}


public void setItinerario(String itinerario) {
	this.itinerario = itinerario;
}


public float getPreco() {
	return preco;
}


public void setPreco(float preco) {
	this.preco = preco;
}


public String getDatasDisponiveis() {
	return datasDisponiveis;
}


public void setDatasDisponiveis(String datasDisponiveis) {
	this.datasDisponiveis = datasDisponiveis;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public void Mostrar() {
	System.out.println("=============================================================");
	System.out.println("ID: "+ this.id);
	System.out.println("Destino: "+ this.destino);
	System.out.println("Preço: "+ this.preco);
	System.out.println("Datas Disponiveis: "+ this.datasDisponiveis);
	System.out.println("Itinerario: "+ this.itinerario);
	System.out.println("Descrição: "+ this.descricao);
	System.out.println("=============================================================");
}

}
