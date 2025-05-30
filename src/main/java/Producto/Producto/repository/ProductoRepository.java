package Producto.Producto.repository;

import Producto.Producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNomProductoContainingIgnoreCase(String nomProducto);
    List<Producto> findByCategProducto(String categoria);
}