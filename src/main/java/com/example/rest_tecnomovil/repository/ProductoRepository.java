package com.example.rest_tecnomovil.repository;

import com.example.rest_tecnomovil.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByPrecioLessThan(Double precio);
    List<Producto> findByActivoTrue();

    @Query(value = "SELECT * FROM Producto WHERE stock > 0", nativeQuery = true)
    List<Producto> findAllProductosConStock();

    @Query(value = "SELECT * FROM Producto WHERE precio = :precio", nativeQuery = true)
    List<Producto> findProductosByPrecio(@Param("precio") Double precio);

    @Transactional
    @Modifying
    @Query(value = "UPDATE producto SET stock=:stock WHERE productoid=:productoid", nativeQuery = true)
    void actualizarStockProducto(@Param("stock") Integer stock,
                                 @Param("productoid") Integer productoid);

}
