package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {

	private int ultimoCodigo = 1000;

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}

	public Cuenta crearCuenta(Cliente cliente) {

		String codigoStr = ultimoCodigo + "";
		ultimoCodigo++;
		Cuenta c1 = new Cuenta(codigoStr);
		c1.setPropietario(cliente);
		return c1;
	}
	
	public boolean depositar(Cuenta cuenta, double monto ) {
		if(monto>0) {
			double nuevoSaldo=cuenta.getSaldoActual()+monto;
			cuenta.setSaldoActual(nuevoSaldo);
			return true;
		}else {
			return false;
		}
	}

}
