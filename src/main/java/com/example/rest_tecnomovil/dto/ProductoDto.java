package com.example.rest_tecnomovil.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDto {

    private Integer productoid;
    private String nombre;
    private Double precio;
    private Integer stock;
    private boolean activo;
    private int categoriaid;

}
