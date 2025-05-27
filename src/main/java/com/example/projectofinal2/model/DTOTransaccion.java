package com.example.projectofinal2.model;

import java.time.format.DateTimeFormatter;

public record DTOTransaccion(double monto, String fecha, String descripcion, String categoria, String tipo, CuentaBanco cuentaOrigen, CuentaBanco cuentaDestino) {
    @Override
    public String toString() {
        return String.format("%s - %s: %.2f (%s)",
                fecha.format(String.valueOf(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))),
                tipo,
                monto,
                descripcion);
    }
}
