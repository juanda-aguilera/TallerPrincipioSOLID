package com.gitb.juandaaguilera.principiosSolid;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new VehiculoMensual("KLM321", "Camila Rojas", 180000));       // Paso 2 (OCP)
        vehiculos.add(new VehiculoPorMinutos("XYZ45F", "Andrés Mora", 80, 1500));   // Paso 2 (OCP)
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));
        vehiculos.add(new VehiculoPorDia("DEF789", "Laura Gómez", 25000, 3));       // Paso 2 (OCP): modelo nuevo

        // Paso 2 (prueba para el paso 3): descomente este bloque para ver el error de Liskov.
        // Bicicleta promete calcularPuntos() porque hereda de Vehiculo, pero lanza una excepción.
        // for (Vehiculo v : vehiculos) {
        //     System.out.println(v.getPlaca() + " -> puntos: " + v.calcularPuntos());
        // }

        GestorParqueadero gestor = new GestorParqueadero();
        String csv = gestor.cerrarMes(vehiculos);
        System.out.println(csv);
    }
}
