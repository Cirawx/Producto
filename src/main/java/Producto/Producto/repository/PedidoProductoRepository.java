package Producto.Producto.repository;
//coneccion jpa
import Producto.Producto.model.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Integer> {
}
