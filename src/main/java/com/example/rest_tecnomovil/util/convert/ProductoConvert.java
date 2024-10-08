package com.example.rest_tecnomovil.util.convert;

import com.example.rest_tecnomovil.dto.CategoriaDto;
import com.example.rest_tecnomovil.dto.ProductoDto;
import com.example.rest_tecnomovil.model.Categoria;
import com.example.rest_tecnomovil.model.Producto;
import com.example.rest_tecnomovil.service.impl.CategoriaService;
import org.springframework.stereotype.Component;

@Component
public class ProductoConvert {

    public ProductoDto convertirProductoADto(Producto producto) {
        return ProductoDto.builder()
                .productoid(producto.getProductoid())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .activo(producto.isActivo())
                .categoriaid(producto.getCategoria().getCategoriaid())
                .build();
    }

}
