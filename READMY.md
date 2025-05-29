Paso1.-
Crear la base de datos con nombre "Producto"

Paso2.-
Hechar a anadar la maquina
Rellenar la base de datos

INSERT INTO producto (nom_producto, id_proveedor, categ_producto, precio_producto, stock_producto, desc_producto) VALUES
('Esencia de Rosas Nocturnas 50ml', 101, 'Floral', 75.99, 120.0, 'Una fragancia floral intensa con notas de rosa búlgara y sándalo.'),
('Bosque Profundo Homme 100ml', 102, 'Amaderado', 99.50, 80.0, 'Perfume masculino con acordes de cedro, vetiver y musgo.'),
('Aroma Cítrico Vital 30ml', 103, 'Cítrico', 45.00, 200.0, 'Perfume fresco y energizante con notas de limón, bergamota y naranja.'),
('Misterio Oriental Elixir 75ml', 104, 'Oriental', 120.00, 60.0, 'Exquisita mezcla de especias, ámbar y vainilla, para ocasiones especiales.'),
('Brisa Marina Unisex 80ml', 105, 'Fresco', 60.25, 150.0, 'Fragancia ligera y acuática, ideal para el día a día.'),
('Dulce Tentación Gourmand 50ml', 106, 'Gourmand', 88.75, 90.0, 'Perfume dulce con notas de caramelo, chocolate y praliné.'),
('Oud Royal Collection 100ml', 107, 'Nicho', 250.00, 30.0, 'Perfume exclusivo con base de oud, incienso y especias raras.');

INSERT INTO pedido_producto (fecha, estado) VALUES
('2025-05-20', 'ENTREGADO'),         -- Pedido 1
('2025-05-22', 'PREPARANDO_ENVIO'),  -- Pedido 2
('2025-05-25', 'PENDIENTE'),         -- Pedido 3
('2025-05-27', 'CONFIRMADO');        -- Pedido 4

Paso3.- Vincular pedidos con productos

INSERT INTO pedido_producto_item (pedido_id, producto_id) VALUES
(1, (SELECT id_producto FROM producto WHERE nom_producto = 'Esencia de Rosas Nocturnas 50ml')),
(1, (SELECT id_producto FROM producto WHERE nom_producto = 'Aroma Cítrico Vital 30ml'));

-- Pedido 2: Bosque Profundo Homme, Misterio Oriental Elixir
INSERT INTO pedido_producto_item (pedido_id, producto_id) VALUES
(2, (SELECT id_producto FROM producto WHERE nom_producto = 'Bosque Profundo Homme 100ml')),
(2, (SELECT id_producto FROM producto WHERE nom_producto = 'Misterio Oriental Elixir 75ml'));

-- Pedido 3: Brisa Marina Unisex
INSERT INTO pedido_producto_item (pedido_id, producto_id) VALUES
(3, (SELECT id_producto FROM producto WHERE nom_producto = 'Brisa Marina Unisex 80ml'));

-- Pedido 4: Dulce Tentación Gourmand, Oud Royal Collection, Esencia de Rosas Nocturnas
INSERT INTO pedido_producto_item (pedido_id, producto_id) VALUES
(4, (SELECT id_producto FROM producto WHERE nom_producto = 'Dulce Tentación Gourmand 50ml')),
(4, (SELECT id_producto FROM producto WHERE nom_producto = 'Oud Royal Collection 100ml')),
(4, (SELECT id_producto FROM producto WHERE nom_producto = 'Esencia de Rosas Nocturnas 50ml'));

Paso 4.- En postman

Listar pedidos: localhost:8080/api/pedidos  GET
Listar pedidos: localhost:8080/api/productos  GET

Eliminar pedidos: localhost:8080/id  DELETE
Eliminar producto: localhost:8080/id  DELETE

Paso 5.- 
Ingresar: Body - Raw - Pegar json POST
{
    "nomProducto": "Vainilla Encantada 60ml",
    "idProveedor": 108,
    "categProducto": "Gourmand",
    "precioProducto": 65.50,
    "stockProducto": 180.0,
    "descProducto": "Perfume cálido con notas dominantes de vainilla, azúcar moreno y un toque de canela."
}
{
    "fecha": "2025-05-29",
    "estado": "CONFIRMADO",
    "cantProductos": [
        {
            "idProducto": 1
        },
        {
            "idProducto": 3
        },
        {
            "idProducto": 5
        }
    ]
}