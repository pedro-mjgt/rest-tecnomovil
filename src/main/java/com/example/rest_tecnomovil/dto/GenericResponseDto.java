package com.example.rest_tecnomovil.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class GenericResponseDto<T> {

    private boolean correcto;
    private String mensaje;
    private T respuesta;
    private String codigoError;
    private HttpStatus status;

}
