package com.krakedev.financiero.entidades;

public class Cuenta {
	
	private String id;
	private double saldoActual;
	private String tipo;
	private Cliente propietario;
	
	
	public Cuenta(String id) {
		this.id = id;
		saldoActual=0;
		tipo="A";
		propietario=new Cliente();
	}


	public Cliente getPropietario() {
		return propietario;
	}


	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public double getSaldoActual() {
		return saldoActual;
	}


	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void imprimir() {
		
		System.out.println("Id: " + id);
		System.out.println("Saldo Actual: " + saldoActual);
		System.out.println("Tipo: " + tipo);
		System.out.println("Cédula cliente: " + propietario.getCedula());
		
	}
	
	
	public void crearCuenta(Cliente cliente) {
		
		String codigoStr=ultimoCodigo +"";
		ultimoCodigo ++;
		Cuenta c1= new Cuenta(codigoStr);
		c1.setPropietario(cliente);
		
	}
	

}
