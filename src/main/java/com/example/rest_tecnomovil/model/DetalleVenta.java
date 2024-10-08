package com.example.rest_tecnomovil.model;

import com.example.rest_tecnomovil.model.pk.VentaProductoId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalleventa")
public class DetalleVenta {

    @EmbeddedId
    private VentaProductoId id;

    private Integer cantidad;
    private Double preciounitario;

    @ManyToOne
    @MapsId("ventaid")
    @JoinColumn(name = "ventaid")
    @JsonBackReference
    private Venta venta;

    @ManyToOne
    @MapsId("productoid")
    @JoinColumn(name = "productoid")
    @JsonBackReference
    private Producto producto;

}
