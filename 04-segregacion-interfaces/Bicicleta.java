package com.gitb.juandaaguilera.principiosSolid;

public class Bicicleta extends Vehiculo {

    public Bicicleta(String codigo, String propietario, double valorMensualidad) {
        super(codigo, propietario, valorMensualidad);
    }

    @Override
    public double calcularCobro() {
        return valorMensualidad;
    }

}
