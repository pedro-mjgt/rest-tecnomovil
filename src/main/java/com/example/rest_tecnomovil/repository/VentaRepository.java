package com.example.rest_tecnomovil.repository;

import com.example.rest_tecnomovil.model.Cliente;
import com.example.rest_tecnomovil.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = "SELECT v FROM Venta v WHERE v.cliente=:cliente")
    List<Venta> obtenerVentasXCliente(@Param("cliente") Cliente cliente);

    @Query("SELECT v FROM Venta v WHERE v.fecha BETWEEN :startDate AND :endDate")
    List<Venta> findVentasBetweenFechas(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


}
