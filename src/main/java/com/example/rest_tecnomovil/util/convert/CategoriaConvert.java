package com.example.rest_tecnomovil.util.convert;

import com.example.rest_tecnomovil.dto.CategoriaDto;
import com.example.rest_tecnomovil.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConvert {

    public CategoriaDto convertirCategoriaADto(Categoria categoria) {
        return CategoriaDto.builder()
                .categoriaid(categoria.getCategoriaid())
                .nombre(categoria.getNombre())
                .build();
    }

    public Categoria convertirCategoriaDtoACategoria(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();

        categoria.setCategoriaid(categoriaDto.getCategoriaid());
        categoria.setNombre(categoriaDto.getNombre());

        return categoria;
    }

}
