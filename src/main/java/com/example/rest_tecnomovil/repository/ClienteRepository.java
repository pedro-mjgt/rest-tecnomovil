package com.example.rest_tecnomovil.repository;

import com.example.rest_tecnomovil.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT c FROM Cliente c WHERE c.email=:email")
    Optional<Cliente> obtenerClienteXEmail(@Param("email") String email);

    @Query(value = "SELECT c FROM Cliente c WHERE c.telefono LIKE %:telefono%")
    List<Cliente> obtenerClientesXTelefono(@Param("telefono") String telefono);

}
