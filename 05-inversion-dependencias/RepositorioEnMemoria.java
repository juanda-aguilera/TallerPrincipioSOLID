package com.gitb.juandaaguilera.principiosSolid;

import java.util.ArrayList;
import java.util.List;

// Paso 5 (DIP): implementación para probar sin base de datos
public class RepositorioEnMemoria implements RepositorioCobros {   // Paso 5 (DIP)
    private List<String> registros = new ArrayList<>();   // Paso 5 (DIP)

    @Override   // Paso 5 (DIP)
    public void insertar(String placa, double cobro) {
        registros.add(placa + ";" + cobro);
    }

    public List<String> getRegistros() { return registros; }   // Paso 5 (DIP): para verificar en las pruebas
}
