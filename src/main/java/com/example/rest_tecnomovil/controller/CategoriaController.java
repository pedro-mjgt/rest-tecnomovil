package com.example.rest_tecnomovil.controller;

import com.example.rest_tecnomovil.dto.CategoriaDto;
import com.example.rest_tecnomovil.dto.GenericResponseDto;
import com.example.rest_tecnomovil.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/categoria")
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @GetMapping("")
    public ResponseEntity<GenericResponseDto<Optional<CategoriaDto>>> obtenerCategoriaXNombre(
            @RequestParam("nombre") String nombre
    ) {
        Optional<CategoriaDto> categoriaDto = categoriaService.findByNombre(nombre);

        if (categoriaDto.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <Optional<CategoriaDto>>builder()
                    .correcto(false)
                    .mensaje("No existe la categoria").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <Optional<CategoriaDto>>builder()
                    .mensaje("Categoria por nombre")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(categoriaDto).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/")
    public ResponseEntity<GenericResponseDto<List<CategoriaDto>>> obtenerCategoriasXNombre(
            @RequestParam("nombre") String nombre
    ) {
        List<CategoriaDto> categoriaDtos = categoriaService.findByNombreContaining(nombre);

        if (categoriaDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<CategoriaDto>>builder()
                    .correcto(false)
                    .mensaje("No existen categorias").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<CategoriaDto>>builder()
                    .mensaje("Lista de categorias por nombre")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(categoriaDtos).build(), HttpStatus.OK);
        }
    }

}
