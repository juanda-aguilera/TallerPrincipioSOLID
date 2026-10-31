package com.gitb.juandaaguilera.principiosSolid;

public abstract class Vehiculo implements ServicioParqueadero {
    protected String placa;
    protected String propietario;
    protected double valorMensualidad;
    protected int minutos;
    protected int lavados;

    public Vehiculo(String placa, String propietario, double valorMensualidad) {
        this.placa = placa;
        this.propietario = propietario;
        this.valorMensualidad = valorMensualidad;
    }

    public String getPlaca()            { return placa; }
    public String getPropietario()      { return propietario; }
    public double getValorMensualidad() { return valorMensualidad; }
    public int getMinutos()             { return minutos; }

    public abstract double calcularCobro();

    // Paso 3 (LSP): calcularPuntos() sale de Vehiculo; ya no se le promete a todos los subtipos

    public void registrarMinutos(int minutos) { this.minutos += minutos; }
    public double calcularSeguro()            { return valorMensualidad * 0.02; }
    public void solicitarLavados(int cantidad) { this.lavados += cantidad; }
}
