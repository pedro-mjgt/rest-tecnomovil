package com.example.rest_tecnomovil.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DetalleVentaDto {

    private Integer ventaid;
    private Integer productoid;
    private Integer cantidad;
    private Double preciounitario;

}
