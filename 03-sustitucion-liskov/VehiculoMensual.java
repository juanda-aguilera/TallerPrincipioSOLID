package com.gitb.juandaaguilera.principiosSolid;

public class VehiculoMensual extends Vehiculo implements Fidelizable {   // Paso 3 (LSP): acumula puntos

    public VehiculoMensual(String placa, String propietario, double valorMensualidad) {
        super(placa, propietario, valorMensualidad);
    }

    @Override
    public double calcularCobro() {
        return valorMensualidad;
    }

    // Paso 3 (LSP): puntos del programa de fidelidad: 1 punto por cada $10.000 de mensualidad.
    @Override
    public int calcularPuntos() {
        return (int) (valorMensualidad / 10000);
    }
}
