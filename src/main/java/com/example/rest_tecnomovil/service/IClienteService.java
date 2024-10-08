package com.example.rest_tecnomovil.service;

import com.example.rest_tecnomovil.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    Optional<ClienteDto> obtenerClienteXEmail(String email);
    List<ClienteDto> obtenerClientesXTelefono(String telefono);

}
