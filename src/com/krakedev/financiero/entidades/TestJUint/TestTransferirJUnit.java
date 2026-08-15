package com.krakedev.financiero.entidades.TestJUint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestTransferirJUnit {

    @Test
    public void testTransferenciaExitosa() {
        Banco banco = new Banco();
        Cliente c1 = new Cliente("1712345678", "Carlos", "Andrade");
        Cliente c2 = new Cliente("1787654321", "Ana", "Morales");

        Cuenta origen = banco.crearCuenta(c1);
        Cuenta destino = banco.crearCuenta(c2);

        // Saldo inicial en origen
        banco.depositar(origen, 200.0);

        boolean resultado = banco.transferir(origen, destino, 80.0);

        assertTrue(resultado);
        assertEquals(120.0, origen.getSaldoActual(), 0.0001);
        assertEquals(80.0, destino.getSaldoActual(), 0.0001);
    }

    @Test
    public void testTransferenciaSaldoInsuficiente() {
        Banco banco = new Banco();
        Cliente c1 = new Cliente("1712345678", "Carlos", "Andrade");
        Cliente c2 = new Cliente("1787654321", "Ana", "Morales");

        Cuenta origen = banco.crearCuenta(c1);
        Cuenta destino = banco.crearCuenta(c2);

        banco.depositar(origen, 50.0);

        // Intento de transferir un monto mayor al saldo
        boolean resultado = banco.transferir(origen, destino, 100.0);

        assertFalse(resultado);
        assertEquals(50.0, origen.getSaldoActual(), 0.0001);
        assertEquals(0.0, destino.getSaldoActual(), 0.0001);
    }

    @Test
    public void testTransferenciaMontoNegativo() {
        Banco banco = new Banco();
        Cliente c1 = new Cliente("1712345678", "Carlos", "Andrade");
        Cliente c2 = new Cliente("1787654321", "Ana", "Morales");

        Cuenta origen = banco.crearCuenta(c1);
        Cuenta destino = banco.crearCuenta(c2);

        banco.depositar(origen, 100.0);

        // Intento de transferir monto inválido
        boolean resultado = banco.transferir(origen, destino, -20.0);

        assertFalse(resultado);
        assertEquals(100.0, origen.getSaldoActual(), 0.0001);
        assertEquals(0.0, destino.getSaldoActual(), 0.0001);
    }
}