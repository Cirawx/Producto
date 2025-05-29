
package Producto.Producto.service;

import Producto.Producto.model.Producto;
import Producto.Producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(int idProd) {
        productoRepository.deleteById(idProd);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto buscarProductoPorId(int idProd) {
        return productoRepository.findById(idProd).orElse(null);
    }
    
}
