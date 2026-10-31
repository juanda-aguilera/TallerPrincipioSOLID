package com.gitb.juandaaguilera.principiosSolid;

public class Bicicleta extends Vehiculo {   // Paso 3 (LSP): extiende Vehiculo directamente, no es Fidelizable

    public Bicicleta(String codigo, String propietario, double valorMensualidad) {
        super(codigo, propietario, valorMensualidad);
    }

    @Override
    public double calcularCobro() {   // Paso 3 (LSP): cobra la mensualidad sin heredar de VehiculoMensual
        return valorMensualidad;
    }

    // Paso 3 (LSP): se elimina el método que lanzaba UnsupportedOperationException
}
