package com.gitb.juandaaguilera.principiosSolid;

import java.util.List;

public class GestorParqueadero {
    private RepositorioMySQL repositorio = new RepositorioMySQL();
    private ExportadorCSV exportador = new ExportadorCSV();
    private NotificadorSMS notificador = new NotificadorSMS();

    public double calcularCobro(Vehiculo v) {
        return v.calcularCobro();
    }

    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }

    public String cerrarMes(List<Vehiculo> vehiculos) {
        for (Vehiculo v : vehiculos) {
            double cobro = calcularCobro(v);
            guardar(v, cobro);
            notificador.enviarRecibo(v, cobro);
        }
        return exportador.exportar(vehiculos, this);
    }
}
