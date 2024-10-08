package com.example.rest_tecnomovil.service;

import com.example.rest_tecnomovil.dto.VentaDto;
import com.example.rest_tecnomovil.model.Cliente;
import com.example.rest_tecnomovil.model.Venta;

import java.util.Date;
import java.util.List;

public interface IVentaService {

    List<VentaDto> obtenerVentasXCliente(Cliente cliente);
    List<VentaDto> findVentasBetweenFechas(Date startDate, Date endDate);

    Venta registrarVenta(VentaDto ventaDto);

}
