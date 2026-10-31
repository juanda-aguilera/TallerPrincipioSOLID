package com.gitb.juandaaguilera.principiosSolid;

public interface RepositorioCobros {   // Paso 5 (DIP): abstracción de la que depende el gestor
    void insertar(String placa, double cobro);
}
