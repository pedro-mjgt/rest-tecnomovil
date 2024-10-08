package com.example.rest_tecnomovil.service.impl;

import com.example.rest_tecnomovil.dto.ProductoDto;
import com.example.rest_tecnomovil.model.Producto;
import com.example.rest_tecnomovil.repository.ProductoRepository;
import com.example.rest_tecnomovil.service.IProductoService;
import com.example.rest_tecnomovil.util.convert.ProductoConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoConvert productoConvert;

    @Override
    public List<ProductoDto> findByPrecioLessThan(Double precio) {
        List<ProductoDto> productoDtos = new ArrayList<>();

        for (Producto producto : productoRepository.findByPrecioLessThan(precio)) {
            productoDtos.add(productoConvert.convertirProductoADto(producto));
        }

        return productoDtos;
    }

    @Override
    public List<ProductoDto> findByActivoTrue() {
        List<ProductoDto> productoDtos = new ArrayList<>();

        for (Producto producto : productoRepository.findByActivoTrue()) {
            productoDtos.add(productoConvert.convertirProductoADto(producto));
        }

        return productoDtos;
    }

    @Override
    public List<ProductoDto> findAllProductosConStock() {
        List<ProductoDto> productoDtos = new ArrayList<>();

        for (Producto producto : productoRepository.findAllProductosConStock()) {
            productoDtos.add(productoConvert.convertirProductoADto(producto));
        }

        return productoDtos;
    }

    @Override
    public List<ProductoDto> findProductosByPrecio(Double precio) {
        List<ProductoDto> productoDtos = new ArrayList<>();

        for (Producto producto : productoRepository.findProductosByPrecio(precio)) {
            productoDtos.add(productoConvert.convertirProductoADto(producto));
        }

        return productoDtos;
    }

    @Override
    public void actualizarStockProducto(Integer stock, Integer productoid) {
        productoRepository.actualizarStockProducto(stock, productoid);
    }

}
