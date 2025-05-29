package Producto.Producto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    private LocalDate fecha;
    private String estado;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "pedido_producto_item",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> cantProductos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        if (this.cantProductos == null) {
            this.cantProductos = new ArrayList<>();
        }
        this.cantProductos.add(p);
    }

    public void quitarProducto(Producto p) {
        if (this.cantProductos != null) {
            this.cantProductos.remove(p);
        }
    }
}