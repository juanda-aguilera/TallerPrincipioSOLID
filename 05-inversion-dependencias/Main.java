package com.gitb.juandaaguilera.principiosSolid;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new VehiculoMensual("KLM321", "Camila Rojas", 180000));
        vehiculos.add(new VehiculoPorMinutos("XYZ45F", "Andrés Mora", 80, 1500));
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));
        vehiculos.add(new VehiculoPorDia("DEF789", "Laura Gómez", 25000, 3));

        // Paso 5 (DIP): prueba sin base de datos usando el repositorio en memoria
        System.out.println("=== Prueba con RepositorioEnMemoria ===");
        RepositorioEnMemoria memoria = new RepositorioEnMemoria();
        GestorParqueadero gestorPrueba = new GestorParqueadero(memoria);
        gestorPrueba.cerrarMes(vehiculos);
        boolean ok = memoria.getRegistros().size() == vehiculos.size();
        System.out.println("Registros guardados en memoria: " + memoria.getRegistros());
        System.out.println(ok ? "PRUEBA OK" : "PRUEBA FALLIDA");

        // Paso 5 (DIP): el mismo gestor, ahora con la implementación "real"
        System.out.println();
        System.out.println("=== Ejecución con RepositorioMySQL ===");
        GestorParqueadero gestor = new GestorParqueadero(new RepositorioMySQL());
        String csv = gestor.cerrarMes(vehiculos);
        System.out.println(csv);
    }
}
