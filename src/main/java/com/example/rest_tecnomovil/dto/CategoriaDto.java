package com.example.rest_tecnomovil.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaDto {

    private Integer categoriaid;
    private String nombre;

}
