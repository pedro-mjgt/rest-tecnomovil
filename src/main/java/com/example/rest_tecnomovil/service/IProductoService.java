package com.example.rest_tecnomovil.service;

import com.example.rest_tecnomovil.dto.ProductoDto;

import java.util.List;

public interface IProductoService {

    List<ProductoDto> findByPrecioLessThan(Double precio);
    List<ProductoDto> findByActivoTrue();
    List<ProductoDto> findAllProductosConStock();
    List<ProductoDto> findProductosByPrecio(Double precio);

    void actualizarStockProducto(Integer stock, Integer productoid);

}
