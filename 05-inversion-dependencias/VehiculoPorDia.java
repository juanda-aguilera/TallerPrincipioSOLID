package com.gitb.juandaaguilera.principiosSolid;

// (solo se crean objetos de esta clase en Main).
public class VehiculoPorDia extends Vehiculo {
    private double tarifaDia;
    private int dias;

    public VehiculoPorDia(String placa, String propietario, double tarifaDia, int dias) {
        super(placa, propietario, 0);
        this.tarifaDia = tarifaDia;
        this.dias = dias;
    }

    @Override
    public double calcularCobro() {
        return dias * tarifaDia;
    }
}
