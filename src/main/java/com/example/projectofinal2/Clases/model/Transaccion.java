package com.example.projectofinal2.Clases.model;

import java.time.LocalDateTime;

public record Transaccion(LocalDateTime fecha, double monto, String descripcion, CategoriaTransaccion categoria,
                          TipoTransaccion tipo) {
}
