package com.gitb.juandaaguilera.principiosSolid;

public abstract class Vehiculo implements ServicioParqueadero {   // Paso 2 (OCP): ahora es abstracta
    protected String placa;
    protected String propietario;
    // Paso 2 (OCP): se elimina el campo "tipo"; ya no hay switch que lo consulte
    protected double valorMensualidad;
    protected int minutos;
    protected int lavados;

    public Vehiculo(String placa, String propietario, double valorMensualidad) {   // Paso 2 (OCP): sin tipo, tarifaMinuto ni minutos
        this.placa = placa;
        this.propietario = propietario;
        this.valorMensualidad = valorMensualidad;
    }

    public String getPlaca()            { return placa; }
    public String getPropietario()      { return propietario; }
    public double getValorMensualidad() { return valorMensualidad; }
    public int getMinutos()             { return minutos; }

    // Paso 2 (OCP): cada modelo de cobro define su propia fórmula
    public abstract double calcularCobro();

    // Puntos del programa de fidelidad: 1 punto por cada $10.000 de mensualidad.
    public int calcularPuntos() {
        return (int) (valorMensualidad / 10000);
    }

    public void registrarMinutos(int minutos) { this.minutos += minutos; }
    public double calcularSeguro()            { return valorMensualidad * 0.02; }
    public void solicitarLavados(int cantidad) { this.lavados += cantidad; }
}
