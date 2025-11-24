package com.example.clientes_venta.Producto;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "producto"
)

public class Producto {
    
    @Id
    @SequenceGenerator(
            name = "producto_id_seq",
            sequenceName = "producto_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "producto_id_seq"
    )
    private Integer id;
    
    @Column(nullable = false)
    private Integer stock;
    
    @Column(nullable = false)
    private Float precio;
    //private byte imagen;

    public Producto() {
    }

    public Producto(Integer id, Integer stock, Float precio) {
        this.id = id;
        this.stock = stock;
        this.precio = precio;
    }

    public Producto(Integer stock, Float precio) {
        this.stock = stock;
        this.precio = precio;
    }
    
    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getStock () {
        return stock;
    }

    public void setStock (Integer stock) {
        this.stock = stock;
    }

    public Float getPrecio () {
        return precio;
    }

    public void setPrecio (Float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}