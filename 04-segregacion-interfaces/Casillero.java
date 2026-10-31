package com.gitb.juandaaguilera.principiosSolid;

// Casillero para guardar cascos y maletas. Se cobra por minuto de uso.
public class Casillero implements ConMinutos {   // Paso 4 (ISP): solo implementa lo que realmente hace
    private String codigo;
    private String usuario;
    private double tarifaMinuto;
    private int minutos;

    public Casillero(String codigo, String usuario, double tarifaMinuto) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.tarifaMinuto = tarifaMinuto;
    }

    public void registrarMinutos(int minutos) { this.minutos += minutos; }

    // Paso 4 (ISP): se eliminan calcularSeguro() y solicitarLavados(), que estaban vacíos

    public double valorAlquiler() { return minutos * tarifaMinuto; }
}
