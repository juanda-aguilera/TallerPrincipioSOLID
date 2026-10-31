package com.gitb.juandaaguilera.principiosSolid;

// Paso 3 (LSP): solo quien realmente acumula puntos promete calcularlos.
public interface Fidelizable {   // Paso 3 (LSP): interfaz nueva
    int calcularPuntos();
}
