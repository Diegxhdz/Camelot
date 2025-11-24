package com.example.clientes_venta.Producto;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "servicios"
)
public class Servicios {
    @Id
    @SequenceGenerator(
            name = "servicios_id_seq",
            sequenceName = "servicios_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "servicios_id_seq"
    )
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;
    
    @Column(nullable = false)
    private Float precio;
    
    @Column(nullable = false)
    private String hora;

    public Servicios() {
    }

    public Servicios(String nombre, Float precio, String hora) {
        this.nombre = nombre;
        this.precio = precio;
        this.hora = hora;
    }

    public Servicios(Integer id, String nombre, Float precio, String hora) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicios servicios = (Servicios) o;
        return Objects.equals(id, servicios.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Servicios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", hora='" + hora + '\'' +
                '}';
    }
}