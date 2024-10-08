package com.example.rest_tecnomovil.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class VentaDto {

    private Integer ventaid;
    private Date fecha;
    private Integer clienteid;

    private List<DetalleVentaDto> detalleVentaDto;

}
