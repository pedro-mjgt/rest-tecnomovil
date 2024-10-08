package com.example.rest_tecnomovil.controller;

import com.example.rest_tecnomovil.dto.CategoriaDto;
import com.example.rest_tecnomovil.dto.ClienteDto;
import com.example.rest_tecnomovil.dto.GenericResponseDto;
import com.example.rest_tecnomovil.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<GenericResponseDto<Optional<ClienteDto>>> obternerClienteXEmail(
            @RequestParam("email") String email
    ) {
        Optional<ClienteDto> clienteDto = clienteService.obtenerClienteXEmail(email);

        if (clienteDto.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <Optional<ClienteDto>>builder()
                    .correcto(false)
                    .mensaje("No existe el cliente").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <Optional<ClienteDto>>builder()
                    .mensaje("Cliente por email")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(clienteDto).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/")
    public ResponseEntity<GenericResponseDto<List<ClienteDto>>> obtenerClientesXTelefoono(
            @RequestParam("telefono") String telefono
    ) {
        List<ClienteDto> clienteDtos = clienteService.obtenerClientesXTelefono(telefono);

        if (clienteDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ClienteDto>>builder()
                    .correcto(false)
                    .mensaje("No existen clientes").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ClienteDto>>builder()
                    .mensaje("Lista de clientes por telefono")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(clienteDtos).build(), HttpStatus.OK);
        }
    }

}
