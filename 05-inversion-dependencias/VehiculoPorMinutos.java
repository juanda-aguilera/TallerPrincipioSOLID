package com.gitb.juandaaguilera.principiosSolid;

public class VehiculoPorMinutos extends Vehiculo {
    private double tarifaMinuto;

    public VehiculoPorMinutos(String placa, String propietario, double tarifaMinuto, int minutos) {
        super(placa, propietario, 0);
        this.tarifaMinuto = tarifaMinuto;
        this.minutos = minutos;
    }

    public double getTarifaMinuto() { return tarifaMinuto; }

    @Override
    public double calcularCobro() {
        return minutos * tarifaMinuto;
    }
}
