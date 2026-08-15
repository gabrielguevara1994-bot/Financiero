package com.krakedev.financiero.test.testJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class BancoTest {

    @Test
    public void testCodigosConsecutivos() {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("1712345678", "Carlos", "Andrade");
        Cliente cliente2 = new Cliente("1787654321", "Ana", "Morales");
        Cliente cliente3 = new Cliente("1790001112", "David", "Vargas");

        // Creación consecutiva de cuentas
        Cuenta cuenta1 = banco.crearCuenta(cliente1);
        Cuenta cuenta2 = banco.crearCuenta(cliente2);
        Cuenta cuenta3 = banco.crearCuenta(cliente3);

        // Validación de códigos consecutivos a partir de 1000
        assertEquals("1000", cuenta1.getId());
        assertEquals("1001", cuenta2.getId());
        assertEquals("1002", cuenta3.getId());

        // Validación de incremento del atributo interno en la clase Banco
        assertEquals(1003, banco.getUltimoCodigo());

        // Validaciones complementarias de la entidad Cuenta
        assertEquals("A", cuenta1.getTipo());
        assertEquals(0.0, cuenta1.getSaldoActual(), 0.0001);
        assertNotNull(cuenta1.getPropietario());
        assertEquals("1712345678", cuenta1.getPropietario().getCedula());
    }
}