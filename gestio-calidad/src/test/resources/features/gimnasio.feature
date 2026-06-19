Feature: Gestión de Gimnasio
  Como administrador del gimnasio
  Quiero automatizar las reglas de negocio
  Para evitar errores en cobros y accesos

  Scenario: Calcular costo de membresía con descuento por pago en efectivo
    Given un cliente solicita 2 meses de membresia
    When el cliente elige pagar en efectivo
    Then el costo total a cobrar debe ser 27000.0 pesos

  Scenario: Denegar acceso a socio con deuda pendiente
    Given un socio con 15 dias de membresia restantes
    When el sistema verifica que el socio tiene deuda
    Then el ingreso debe ser denegado