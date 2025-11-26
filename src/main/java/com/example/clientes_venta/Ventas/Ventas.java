package com.example.clientes_venta.Ventas;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ventas")
public class Ventas {

    private Integer id;

    private Integer cantidad;

    private String fecha;
}
