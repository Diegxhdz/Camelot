package com.example.clientes_venta.Compras;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="compras")
public class Compras {

    @Id
    private Integer id;

    private Integer cantidad;

    private String fecha;

}
