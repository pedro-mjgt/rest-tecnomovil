package com.example.rest_tecnomovil.repository;

import com.example.rest_tecnomovil.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNombre(String nombre);
    List<Categoria> findByNombreContaining(String nombre);

}
