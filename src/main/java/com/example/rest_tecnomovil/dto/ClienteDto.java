package com.example.rest_tecnomovil.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDto {

    private Integer clienteid;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;

}
