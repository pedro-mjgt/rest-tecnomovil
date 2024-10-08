package com.example.rest_tecnomovil.service.impl;

import com.example.rest_tecnomovil.dto.ClienteDto;
import com.example.rest_tecnomovil.model.Cliente;
import com.example.rest_tecnomovil.repository.ClienteRepository;
import com.example.rest_tecnomovil.service.IClienteService;
import com.example.rest_tecnomovil.util.convert.ClienteConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteConvert clienteConvert;

    @Override
    public Optional<ClienteDto> obtenerClienteXEmail(String email) {
        return clienteRepository.obtenerClienteXEmail(email)
                .map(clienteConvert::convertirClienteADto);
    }

    @Override
    public List<ClienteDto> obtenerClientesXTelefono(String telefono) {
        List<ClienteDto> clienteDtos = new ArrayList<>();

        for (Cliente cliente : clienteRepository.obtenerClientesXTelefono(telefono)) {
            clienteDtos.add(clienteConvert.convertirClienteADto(cliente));
        }

        return clienteDtos;
    }

    public Cliente findClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

}
