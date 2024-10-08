package com.example.rest_tecnomovil.service.impl;

import com.example.rest_tecnomovil.dto.DetalleVentaDto;
import com.example.rest_tecnomovil.model.DetalleVenta;
import com.example.rest_tecnomovil.model.pk.VentaProductoId;
import com.example.rest_tecnomovil.repository.DetalleVentaRepository;
import com.example.rest_tecnomovil.service.IDetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DetalleVentaService implements IDetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public DetalleVenta registrarDetalleVenta(DetalleVentaDto detalleVentaDto) {
        DetalleVenta detalleVenta = new DetalleVenta();
        VentaProductoId ventaProductoId = new VentaProductoId();

        ventaProductoId.setVentaid(detalleVentaDto.getVentaid());
        ventaProductoId.setProductoid(detalleVentaDto.getProductoid());
        detalleVenta.setCantidad(detalleVentaDto.getCantidad());
        detalleVenta.setPreciounitario(detalleVentaDto.getPreciounitario());

        return detalleVentaRepository.save(detalleVenta);
    }
}
