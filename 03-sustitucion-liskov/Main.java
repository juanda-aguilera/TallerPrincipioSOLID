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

        // Paso 3 (LSP): el bloque que fallaba en el paso 2 ahora funciona; solo los Fidelizable calculan puntos
        for (Vehiculo v : vehiculos) {
            if (v instanceof Fidelizable) {
                Fidelizable f = (Fidelizable) v;
                System.out.println(v.getPlaca() + " -> puntos: " + f.calcularPuntos());
            }
        }

        GestorParqueadero gestor = new GestorParqueadero();
        String csv = gestor.cerrarMes(vehiculos);
        System.out.println(csv);
    }
}
