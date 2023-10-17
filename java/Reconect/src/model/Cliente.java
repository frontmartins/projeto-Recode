package model;

public class Cliente {
private int id;
private String nome;
private String endereco;
private String telefone;
private String email;
private String historicoDeViagem;


public Cliente() {
	super();
}
public Cliente(String nome, String endereco, String telefone, String email, String historicoDeViagem) {
	super();
	this.nome = nome;
	this.endereco = endereco;
	this.telefone = telefone;
	this.email = email;
	this.historicoDeViagem = historicoDeViagem;
}
public Cliente(int id, String nome, String endereco, String telefone, String email, String historicoDeViagem) {
	super();
	this.id = id;
	this.nome = nome;
	this.endereco = endereco;
	this.telefone = telefone;
	this.email = email;
	this.historicoDeViagem = historicoDeViagem;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getHistoricoDeViagem() {
	return historicoDeViagem;
}
public void setHistoricoDeViagem(String historicoDeViagem) {
	this.historicoDeViagem = historicoDeViagem;
}

public void Mostrar() {
	System.out.println("=============================================================");
	System.out.println("ID: "+ this.id);
	System.out.println("Nome: "+ this.nome);
	System.out.println("Email: "+ this.email);
	System.out.println("Telefone: "+ this.telefone);
	System.out.println("Historico: "+ this.historicoDeViagem);
	System.out.println("Endereço: "+ this.endereco);
	System.out.println("=============================================================");
}
}
