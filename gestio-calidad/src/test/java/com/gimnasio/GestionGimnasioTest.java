package com.gimnasio;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GestionGimnasioTest {

    @Test
    public void testCalcularCostoSinDescuento() {
        // 1. Preparar (Arrange): Instanciamos la clase que vamos a probar
        GestionGimnasio gym = new GestionGimnasio();
        
        // 2. Ejecutar (Act): Llamamos al método con 2 meses y false (sin efectivo)
        double resultadoObtenido = gym.calcularCosto(2, false);
        
        // 3. Verificar (Assert): 15000 * 2 = 30000.0. El 0.01 es el margen de error aceptado para decimales.
        double resultadoEsperado = 30000.0;
        assertEquals(resultadoEsperado, resultadoObtenido, 0.01);
    }

    @Test
    public void testCircuitoOperativoIngresoGimnasio() {
        GestionGimnasio gym = new GestionGimnasio();
        
        // Paso 1 del circuito: El cliente calcula el costo de 3 meses en efectivo
        double costoCobrado = gym.calcularCosto(3, true);
        
        // Verificamos que el sistema haya calculado bien el descuento (15000 * 3 = 45000 - 10% = 40500)
        assertEquals(40500.0, costoCobrado, 0.01);
        
        // Paso 2 del circuito: Como el cliente pagó, simulamos que no tiene deuda y le quedan 90 días
        boolean simularPagoRealizado = (costoCobrado == 40500.0); 
        boolean puedeIngresar = gym.permitirIngreso(90, !simularPagoRealizado);
        
        // Verificamos que el circuito completo termine permitiéndole el paso
        assertEquals(true, puedeIngresar);
    }
}