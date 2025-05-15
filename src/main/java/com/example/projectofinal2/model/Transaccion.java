package com.example.projectofinal2.model;

import java.time.LocalDateTime;

public record Transaccion(LocalDateTime fecha, double monto, String descripcion, CategoriaTransaccion categoria,
                          TipoTransaccion tipo) {
}
