package com.gitb.juandaaguilera.principiosSolid;

import java.util.List;

public class ExportadorCSV {   // Paso 1 (SRP): clase nueva, solo exporta a CSV

    public String exportar(List<Vehiculo> vehiculos, GestorParqueadero gestor) {
        StringBuilder sb = new StringBuilder("placa;propietario;cobro\n");

        for (Vehiculo v : vehiculos) {
            sb.append(v.getPlaca()).append(";")
              .append(v.getPropietario()).append(";")
              .append(gestor.calcularCobro(v)).append("\n");
        }

        return sb.toString();
    }
}
