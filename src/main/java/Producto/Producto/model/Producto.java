package Producto.Producto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Creacion de producto

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nomProducto;
    private int idProveedor;
    private String categProducto;
    private float precioProducto;
    private float stockProducto;
    private String descProducto;
}
