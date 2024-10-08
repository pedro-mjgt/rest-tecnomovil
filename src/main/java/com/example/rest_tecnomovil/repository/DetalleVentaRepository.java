package com.example.rest_tecnomovil.repository;

import com.example.rest_tecnomovil.model.DetalleVenta;
import com.example.rest_tecnomovil.model.pk.VentaProductoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, VentaProductoId> {
}
