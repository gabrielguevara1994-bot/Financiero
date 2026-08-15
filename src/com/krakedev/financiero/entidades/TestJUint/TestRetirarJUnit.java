package com.krakedev.financiero.entidades.TestJUint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestRetirarJUnit {

    @Test
    public void testRetirarExitosoParcial() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Carlos", "Andrade");
        Cuenta cuenta = banco.crearCuenta(cliente);

        // Se deposita saldo inicial para la prueba
        banco.depositar(cuenta, 100.0);

        boolean resultado = banco.retirar(cuenta, 40.0);
        assertTrue(resultado);
        assertEquals(60.0, cuenta.getSaldoActual(), 0.0001);
    }

    @Test
    public void testRetirarSaldoCompleto() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1787654321", "Ana", "Morales");
        Cuenta cuenta = banco.crearCuenta(cliente);

        banco.depositar(cuenta, 50.0);

        // Retirar exactamente el total del saldo disponible
        boolean resultado = banco.retirar(cuenta, 50.0);
        assertTrue(resultado);
        assertEquals(0.0, cuenta.getSaldoActual(), 0.0001);
    }

    @Test
    public void testRetirarMontoMayorAlSaldo() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1790001112", "David", "Vargas");
        Cuenta cuenta = banco.crearCuenta(cliente);

        banco.depositar(cuenta, 30.0);

        // Intentar retirar más de lo que tiene disponible
        boolean resultado = banco.retirar(cuenta, 50.0);
        assertFalse(resultado);
        assertEquals(30.0, cuenta.getSaldoActual(), 0.0001);
    }

    @Test
    public void testRetirarMontoCero() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Carlos", "Andrade");
        Cuenta cuenta = banco.crearCuenta(cliente);

        banco.depositar(cuenta, 100.0);

        boolean resultado = banco.retirar(cuenta, 0.0);
        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldoActual(), 0.0001);
    }

    @Test
    public void testRetirarMontoNegativo() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Carlos", "Andrade");
        Cuenta cuenta = banco.crearCuenta(cliente);

        banco.depositar(cuenta, 100.0);

        boolean resultado = banco.retirar(cuenta, -20.0);
        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldoActual(), 0.0001);
    }
}