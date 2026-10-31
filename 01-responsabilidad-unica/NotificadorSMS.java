package com.gitb.juandaaguilera.principiosSolid;

public class NotificadorSMS {   // Paso 1 (SRP): clase nueva, solo envía el SMS

    public void enviarRecibo(Vehiculo v, double cobro) {
        System.out.println(
            "SMS a " + v.getPropietario()
            + " | Placa " + v.getPlaca()
            + ": su cobro de este mes es $"
            + String.format("%,.0f", cobro)
        );
    }
}
