package com.gimnasio;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class GimnasioSteps {
    private GestionGimnasio gym = new GestionGimnasio();
    private int mesesSolicitados;
    private double costoFinal;
    private int diasRestantes;
    private boolean tieneDeuda;
    private boolean accesoPermitido;

    // --- Pasos para el Escenario 1 ---
    @Given("un cliente solicita {int} meses de membresia")
    public void un_cliente_solicita_meses_de_membresia(Integer meses) {
        this.mesesSolicitados = meses;
    }

    @When("el cliente elige pagar en efectivo")
    public void el_cliente_elige_pagar_en_efectivo() {
        this.costoFinal = gym.calcularCosto(this.mesesSolicitados, true);
    }

    @Then("el costo total a cobrar debe ser {double} pesos")
    public void el_costo_total_a_cobrar_debe_ser_pesos(Double costoEsperado) {
        assertEquals(costoEsperado, this.costoFinal, 0.01);
    }

    // --- Pasos para el Escenario 2 ---
    @Given("un socio con {int} dias de membresia restantes")
    public void un_socio_con_dias_de_membresia_restantes(Integer dias) {
        this.diasRestantes = dias;
    }

    @When("el sistema verifica que el socio tiene deuda")
    public void el_sistema_verifica_que_el_socio_tiene_deuda() {
        this.tieneDeuda = true;
        this.accesoPermitido = gym.permitirIngreso(this.diasRestantes, this.tieneDeuda);
    }

    @Then("el ingreso debe ser denegado")
    public void el_ingreso_debe_ser_denegado() {
        assertEquals(false, this.accesoPermitido);
    }
}