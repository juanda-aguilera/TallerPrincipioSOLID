package com.gitb.juandaaguilera.principiosSolid;

public class NotificadorSMS {

    public void enviarRecibo(Vehiculo v, double cobro) {
        System.out.println(
            "SMS a " + v.getPropietario()
            + " | Placa " + v.getPlaca()
            + ": su cobro de este mes es $"
            + String.format("%,.0f", cobro)
        );
    }
}
