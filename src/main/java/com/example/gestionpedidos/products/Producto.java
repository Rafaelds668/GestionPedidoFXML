/**
 * La clase Producto representa un producto en una aplicación de gestión de pedidos. Cada producto contiene información
 * sobre su identificador, nombre, precio y cantidad disponible en el inventario.
 *
 * Esta clase es serializable y utiliza anotaciones de Lombok para simplificar la creación de constructores y métodos getter y setter.
 *
 * @author com.example.gestionpedidos.products
 * @version 1.0
 */
package com.example.gestionpedidos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {
    private Integer id;                    // Identificador único del producto.
    private String nombre;                 // Nombre del producto.
    private Double precio;                // Precio del producto.
    private Integer cantidad_disponible;  // Cantidad disponible en el inventario del producto.
}
