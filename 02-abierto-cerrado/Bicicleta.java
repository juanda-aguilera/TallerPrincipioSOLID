package com.gitb.juandaaguilera.principiosSolid;

public class Bicicleta extends VehiculoMensual {   // Paso 2 (OCP): hereda el cobro mensual

    public Bicicleta(String codigo, String propietario, double valorMensualidad) {
        super(codigo, propietario, valorMensualidad);   // Paso 2 (OCP): ya no se pasa el texto "MENSUAL"
    }

    @Override
    public int calcularPuntos() {
        throw new UnsupportedOperationException(
            "Las bicicletas no acumulan puntos de fidelidad");
    }
}
