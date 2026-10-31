package com.gitb.juandaaguilera.principiosSolid;

// Paso 2 (OCP): modelo de cobro NUEVO. Se agrega sin modificar ninguna clase existente
// (solo se crean objetos de esta clase en Main).
public class VehiculoPorDia extends Vehiculo {   // Paso 2 (OCP)
    private double tarifaDia;
    private int dias;

    public VehiculoPorDia(String placa, String propietario, double tarifaDia, int dias) {
        super(placa, propietario, 0);
        this.tarifaDia = tarifaDia;
        this.dias = dias;
    }

    @Override
    public double calcularCobro() {   // Paso 2 (OCP)
        return dias * tarifaDia;
    }
}
