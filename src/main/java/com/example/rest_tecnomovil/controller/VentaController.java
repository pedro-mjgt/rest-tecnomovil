package com.example.rest_tecnomovil.controller;

import com.example.rest_tecnomovil.dto.ClienteDto;
import com.example.rest_tecnomovil.dto.GenericResponseDto;
import com.example.rest_tecnomovil.dto.VentaDto;
import com.example.rest_tecnomovil.model.Cliente;
import com.example.rest_tecnomovil.model.Venta;
import com.example.rest_tecnomovil.service.IClienteService;
import com.example.rest_tecnomovil.service.IVentaService;
import com.example.rest_tecnomovil.service.impl.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/venta")
public class VentaController {

    private final IVentaService ventaService;
    private final ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<GenericResponseDto<List<VentaDto>>> obtenerVentasXCliente(
            @RequestParam("clienteid") Integer clienteid
    ) {
        Cliente cliente = clienteService.findClienteById(clienteid);
        List<VentaDto> ventaDtos = ventaService.obtenerVentasXCliente(cliente);

        if (ventaDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<VentaDto>>builder()
                    .correcto(false)
                    .mensaje("No existen ventas").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<VentaDto>>builder()
                    .mensaje("Lista de ventas por cliente")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(ventaDtos).build(), HttpStatus.OK);
        }

    }

    @GetMapping("/")
    public ResponseEntity<GenericResponseDto<List<VentaDto>>> obtenerVentasEntreFechas(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        List<VentaDto> ventaDtos = ventaService.findVentasBetweenFechas(startDate, endDate);

        if (ventaDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<VentaDto>>builder()
                    .correcto(false)
                    .mensaje("No existen ventas").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<VentaDto>>builder()
                    .mensaje("Lista de ventas entre fechas")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(ventaDtos).build(), HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDto<VentaDto>> registrarVenta(@RequestBody VentaDto ventaDto) {
        Venta nuevaVenta = ventaService.registrarVenta(ventaDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(GenericResponseDto
                        .<VentaDto>builder()
                        .correcto(true)
                        .mensaje("Venta registrada con éxito")
                        .status(HttpStatus.CREATED)
                        .respuesta(ventaDto)
                        .build()
        );
    }

}
