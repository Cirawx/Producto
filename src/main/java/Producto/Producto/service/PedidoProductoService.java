
package Producto.Producto.service;

import Producto.Producto.model.PedidoProducto;
import Producto.Producto.model.Producto;
import Producto.Producto.repository.PedidoProductoRepository;
import Producto.Producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoProductoService {

    @Autowired
    private PedidoProductoRepository pedidoProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto) {
        if (pedidoProducto.getCantProductos() != null) {
            List<Producto> managedProducts = pedidoProducto.getCantProductos().stream()
                    .map(p -> productoRepository.findById(p.getIdProducto()).orElseThrow(() -> new RuntimeException("Product not found: " + p.getIdProducto())))
                    .toList();
            pedidoProducto.setCantProductos(managedProducts);
        }
        return pedidoProductoRepository.save(pedidoProducto);
    }

    public void eliminarPedidoProducto(int idPedido) {
        pedidoProductoRepository.deleteById(idPedido);
    }

    public List<PedidoProducto> listarPedidoProductos() {
        return pedidoProductoRepository.findAll();
    }

    public PedidoProducto buscarPedidoProductoPorId(int idPedido) {
        return pedidoProductoRepository.findById(idPedido).orElse(null);
    }
}
