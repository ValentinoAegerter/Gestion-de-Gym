public class GestionGimnasio {

    // Método para calcular el costo de la membresía
    public double calcularCosto(int meses, boolean pagoEfectivo) {
        double precioBase = 15000.0;
        double costoTotal = precioBase * meses;
        
        // Variable declarada pero no usada (Code Smell intencional para SonarQube)
        int descuentoNoUsado = 10; 

        if (pagoEfectivo) {
            // Descuento del 10% por pago en efectivo
            costoTotal = costoTotal - (costoTotal * 0.10);
        }

        return costoTotal;
    }

    // Método para verificar si el socio puede ingresar
    public boolean permitirIngreso(int diasRestantes, boolean tieneDeuda) {
        if (tieneDeuda) {
            return false;
        }
        
        // Lógica redundante (Code Smell intencional para SonarQube)
        if (diasRestantes > 0) {
            return true;
        } else {
            return false;
        }
    }
}
    

