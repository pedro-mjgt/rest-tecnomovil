package com.example.rest_tecnomovil.service.impl;

import com.example.rest_tecnomovil.dto.DetalleVentaDto;
import com.example.rest_tecnomovil.dto.VentaDto;
import com.example.rest_tecnomovil.model.Cliente;
import com.example.rest_tecnomovil.model.Venta;
import com.example.rest_tecnomovil.repository.VentaRepository;
import com.example.rest_tecnomovil.service.IDetalleVentaService;
import com.example.rest_tecnomovil.service.IVentaService;
import com.example.rest_tecnomovil.util.convert.VentaConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VentaService implements IVentaService {

    private final VentaRepository ventaRepository;
    private final VentaConvert ventaConvert;
    private final IDetalleVentaService detalleVentaService;

    @Override
    public List<VentaDto> obtenerVentasXCliente(Cliente cliente) {
        List<VentaDto> ventaDtos = new ArrayList<>();

        for (Venta venta : ventaRepository.obtenerVentasXCliente(cliente)) {
            ventaDtos.add(ventaConvert.convertirVentaADto(venta));
        }

        return ventaDtos;
    }

    @Override
    public List<VentaDto> findVentasBetweenFechas(Date startDate, Date endDate) {
        List<VentaDto> ventaDtos = new ArrayList<>();

        for (Venta venta : ventaRepository.findVentasBetweenFechas(startDate, endDate)) {
            ventaDtos.add(ventaConvert.convertirVentaADto(venta));
        }

        return ventaDtos;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Venta registrarVenta(VentaDto ventaDto) {
        Venta venta = new Venta();
        Cliente cliente = new Cliente();
        cliente.setClienteid(ventaDto.getClienteid());
        venta.setCliente(cliente);
        Venta newVenta = ventaRepository.save(venta);

        for (DetalleVentaDto detalleVentaDto : ventaDto.getDetalleVentaDto()) {
            detalleVentaDto.setVentaid(newVenta.getVentaid());
            detalleVentaService.registrarDetalleVenta(detalleVentaDto);
        }

        return newVenta;
    }
}
