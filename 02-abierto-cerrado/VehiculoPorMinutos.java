package com.gitb.juandaaguilera.principiosSolid;

public class VehiculoPorMinutos extends Vehiculo {   // Paso 2 (OCP): modelo de cobro por minutos
    private double tarifaMinuto;

    public VehiculoPorMinutos(String placa, String propietario, double tarifaMinuto, int minutos) {
        super(placa, propietario, 0);
        this.tarifaMinuto = tarifaMinuto;
        this.minutos = minutos;
    }

    public double getTarifaMinuto() { return tarifaMinuto; }

    @Override
    public double calcularCobro() {   // Paso 2 (OCP)
        return minutos * tarifaMinuto;
    }
}
