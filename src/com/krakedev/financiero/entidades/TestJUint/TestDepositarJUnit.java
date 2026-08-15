package com.krakedev.financiero.entidades.TestJUint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestDepositarJUnit {

    @Test
    public void testDepositarMontoPositivo() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Carlos", "Andrade");
        Cuenta cuenta = banco.crearCuenta(cliente);

        // Depósito válido inicial
        boolean resultado1 = banco.depositar(cuenta, 100.0);
        assertTrue(resultado1);
        assertEquals(100.0, cuenta.getSaldoActual(), 0.0001);

        // Segundo depósito acumulativo
        boolean resultado2 = banco.depositar(cuenta, 50.50);
        assertTrue(resultado2);
        assertEquals(150.50, cuenta.getSaldoActual(), 0.0001);
    }

    @Test
    public void testDepositarMontoCero() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1787654321", "Ana", "Morales");
        Cuenta cuenta = banco.crearCuenta(cliente);

        boolean resultado = banco.depositar(cuenta, 0.0);
        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldoActual(), 0.0001);
    }

    @Test
    public void testDepositarMontoNegativo() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1790001112", "David", "Vargas");
        Cuenta cuenta = banco.crearCuenta(cliente);

        boolean resultado = banco.depositar(cuenta, -25.0);
        assertFalse(resultado);
        assertEquals(0.0, cuenta.getSaldoActual(), 0.0001);
    }
}