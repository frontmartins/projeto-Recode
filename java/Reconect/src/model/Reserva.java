package model;

import java.util.Date;

public class Reserva {
private int id;
private Cliente cliente;
private PacoteDeViagem pacote;
private Date dataReserva;
private String statusReserva;


public Reserva() {
	super();
}


public Reserva(Cliente cliente, PacoteDeViagem pacote, Date dataReserva, String statusReserva) {
	super();
	this.cliente = cliente;
	this.pacote = pacote;
	this.dataReserva = dataReserva;
	this.statusReserva = statusReserva;
}


public Reserva(int id, Cliente cliente, PacoteDeViagem pacote, Date dataReserva, String statusReserva) {
	super();
	this.id = id;
	this.cliente = cliente;
	this.pacote = pacote;
	this.dataReserva = dataReserva;
	this.statusReserva = statusReserva;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Cliente getCliente() {
	return cliente;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


public PacoteDeViagem getPacote() {
	return pacote;
}


public void setPacote(PacoteDeViagem pacote) {
	this.pacote = pacote;
}


public Date getDataReserva() {
	return dataReserva;
}


public void setDataReserva(Date dataReserva) {
	this.dataReserva = dataReserva;
}


public String getStatusReserva() {
	return statusReserva;
}


public void setStatusReserva(String statusReserva) {
	this.statusReserva = statusReserva;
}
public void Mostrar() {
	System.out.println("=============================================================");
	System.out.println("ID: "+ this.id);
	System.out.println("Cliente: "+ this.cliente.getNome());
	System.out.println("Pacote: "+ this.pacote.getDescricao());
	System.out.println("Data da reserva: "+ this.dataReserva);
	System.out.println("Status: "+ this.statusReserva);
	System.out.println("=============================================================");
}


}
