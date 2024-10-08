package com.example.rest_tecnomovil.service;

import com.example.rest_tecnomovil.dto.CategoriaDto;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    Optional<CategoriaDto> findByNombre(String nombre);
    List<CategoriaDto> findByNombreContaining(String nombre);

}
