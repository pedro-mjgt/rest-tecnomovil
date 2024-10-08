package com.example.rest_tecnomovil.util.convert;

import com.example.rest_tecnomovil.dto.ClienteDto;
import com.example.rest_tecnomovil.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteConvert {

    public ClienteDto convertirClienteADto(Cliente cliente) {
        return ClienteDto.builder()
                .clienteid(cliente.getClienteid())
                .nombre(cliente.getNombre())
                .direccion(cliente.getDireccion())
                .email(cliente.getEmail())
                .telefono(cliente.getTelefono())
                .build();
    }

}
