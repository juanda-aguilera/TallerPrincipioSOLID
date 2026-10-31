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

        for (Vehiculo v : vehiculos) {
            if (v instanceof Fidelizable) {
                Fidelizable f = (Fidelizable) v;
                System.out.println(v.getPlaca() + " -> puntos: " + f.calcularPuntos());
            }
        }

        // Paso 4 (ISP): el casillero se usa a través de la interfaz pequeña ConMinutos
        Casillero casillero = new Casillero("CAS-12", "Laura Gómez", 50);
        registrarUso(casillero, 90);
        System.out.println("Casillero CAS-12 -> alquiler: $" + String.format("%,.0f", casillero.valorAlquiler()));

        GestorParqueadero gestor = new GestorParqueadero();
        String csv = gestor.cerrarMes(vehiculos);
        System.out.println(csv);
    }

    // Paso 4 (ISP): recibe cualquier cosa que acumule minutos, sin exigir seguro ni lavado
    private static void registrarUso(ConMinutos servicio, int minutos) {
        servicio.registrarMinutos(minutos);
    }
}
