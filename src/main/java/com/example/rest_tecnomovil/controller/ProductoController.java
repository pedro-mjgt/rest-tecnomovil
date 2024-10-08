package com.example.rest_tecnomovil.controller;

import com.example.rest_tecnomovil.dto.CategoriaDto;
import com.example.rest_tecnomovil.dto.GenericResponseDto;
import com.example.rest_tecnomovil.dto.ProductoDto;
import com.example.rest_tecnomovil.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping("")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosPrecioMenor(
            @RequestParam("precio") Double precio
    ) {
        List<ProductoDto> productoDtos = productoService.findByPrecioLessThan(precio);

        if (productoDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existen productos").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .mensaje("Lista de productos precio menor")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(productoDtos).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosActivos() {
        List<ProductoDto> productoDtos = productoService.findByActivoTrue();

        if (productoDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existen productos").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .mensaje("Lista de productos activos")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(productoDtos).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/stock")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosConStock() {
        List<ProductoDto> productoDtos = productoService.findAllProductosConStock();

        if (productoDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existen productos").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .mensaje("Lista de productos con stock")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(productoDtos).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/precio")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosXPrecio(
            @RequestParam("precio") Double precio
    ) {
        List<ProductoDto> productoDtos = productoService.findProductosByPrecio(precio);

        if (productoDtos.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existen productos").build(), HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .mensaje("Lista de productos con precio")
                    .correcto(true)
                    .status(HttpStatus.OK)
                    .respuesta(productoDtos).build(), HttpStatus.OK);
        }
    }

    @PutMapping("")
    public ResponseEntity<GenericResponseDto<Void>> actualizarStockProducto(
            @RequestParam("stock") Integer stock,
            @RequestParam("productoid") Integer productoid
    ) {
        productoService.actualizarStockProducto(stock, productoid);

        return ResponseEntity.ok(GenericResponseDto.<Void>builder()
                .correcto(true)
                .mensaje("Stock actualizado")
                .status(HttpStatus.OK)
                .build());
    }

}
