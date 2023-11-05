/**
 * La clase Item representa un elemento o ítem dentro de un pedido en una aplicación de gestión de pedidos.
 * Cada ítem contiene información sobre un producto, la cantidad solicitada y un código de pedido asociado.
 *
 * Esta clase es serializable y utiliza anotaciones de Lombok para simplificar la creación de constructores y métodos getter y setter.
 *
 * @author com.example.gestionpedidos.item
 * @version 1.0
 */
package com.example.gestionpedidos.item;

import com.example.gestionpedidos.products.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    private Integer id;                // Identificador único del ítem.
    private String codigo_pedido;      // Código del pedido al que pertenece el ítem.
    private Producto producto_id;      // Producto asociado al ítem.
    private Integer cantidad;          // Cantidad solicitada del producto.
}
