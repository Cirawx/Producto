package Producto.Producto.controller;

import Producto.Producto.model.PedidoProducto;
import Producto.Producto.service.PedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoProductoController {

    @Autowired
    private PedidoProductoService pedidoProductoService;

    @PostMapping
    public ResponseEntity<PedidoProducto> crearPedido(@RequestBody PedidoProducto pedidoProducto) {
        PedidoProducto nuevoPedido = pedidoProductoService.crearPedidoProducto(pedidoProducto);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable int id) {
        pedidoProductoService.eliminarPedidoProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<PedidoProducto>> listarPedidos() {
        List<PedidoProducto> pedidos = pedidoProductoService.listarPedidoProductos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoProducto> buscarPedidoPorId(@PathVariable int id) {
        PedidoProducto pedido = pedidoProductoService.buscarPedidoProductoPorId(id);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
