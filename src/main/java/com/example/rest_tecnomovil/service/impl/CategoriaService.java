package com.example.rest_tecnomovil.service.impl;

import com.example.rest_tecnomovil.dto.CategoriaDto;
import com.example.rest_tecnomovil.model.Categoria;
import com.example.rest_tecnomovil.repository.CategoriaRepository;
import com.example.rest_tecnomovil.service.ICategoriaService;
import com.example.rest_tecnomovil.util.convert.CategoriaConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaConvert categoriaConvert;

    @Override
    public Optional<CategoriaDto> findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre)
                .map(categoriaConvert::convertirCategoriaADto);
    }

    @Override
    public List<CategoriaDto> findByNombreContaining(String nombre) {
        List<CategoriaDto> categoriaDtos = new ArrayList<>();

        for (Categoria categoria : categoriaRepository.findByNombreContaining(nombre)) {
            categoriaDtos.add(categoriaConvert.convertirCategoriaADto(categoria));
        }

        return categoriaDtos;
    }

}
