package com.gitb.juandaaguilera.principiosSolid;

import java.util.List;

public class GestorParqueadero {
    private RepositorioMySQL repositorio = new RepositorioMySQL();
    private ExportadorCSV exportador = new ExportadorCSV();      // Paso 1 (SRP): el CSV ya no es del gestor
    private NotificadorSMS notificador = new NotificadorSMS();   // Paso 1 (SRP): el SMS ya no es del gestor

    public double calcularCobro(Vehiculo v) {
        switch (v.getTipo()) {
            case "MENSUAL": return v.getValorMensualidad();
            case "MINUTOS": return v.getMinutos() * v.getTarifaMinuto();
            default: throw new IllegalArgumentException("Tipo desconocido: " + v.getTipo());
        }
    }

    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }

    // Paso 1 (SRP): el gestor conserva el cálculo y solo coordina el cierre de mes
    public String cerrarMes(List<Vehiculo> vehiculos) {
        for (Vehiculo v : vehiculos) {
            double cobro = calcularCobro(v);
            guardar(v, cobro);
            notificador.enviarRecibo(v, cobro);   // Paso 1 (SRP): delega en NotificadorSMS
        }
        return exportador.exportar(vehiculos, this);   // Paso 1 (SRP): delega en ExportadorCSV
    }
}
