package com.example.rest_tecnomovil.service;

import com.example.rest_tecnomovil.dto.DetalleVentaDto;
import com.example.rest_tecnomovil.model.DetalleVenta;

public interface IDetalleVentaService {

    DetalleVenta registrarDetalleVenta(DetalleVentaDto detalleVentaDto);

}
