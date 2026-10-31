package com.gitb.juandaaguilera.principiosSolid;

public class VehiculoMensual extends Vehiculo {   // Paso 2 (OCP): modelo de cobro mensual

    public VehiculoMensual(String placa, String propietario, double valorMensualidad) {
        super(placa, propietario, valorMensualidad);
    }

    @Override
    public double calcularCobro() {   // Paso 2 (OCP)
        return valorMensualidad;
    }
}
