/**
 * La clase Pedido representa un pedido en una aplicación de gestión de pedidos. Cada pedido contiene información
 * sobre su identificador, código, fecha, identificador de usuario, total y una lista de ítems asociados.
 *
 * Esta clase es serializable y utiliza anotaciones de Lombok para simplificar la creación de constructores y métodos getter y setter.
 *
 * @author com.example.gestionpedidos.orders
 * @version 1.0
 */
package com.example.gestionpedidos.orders;

import com.example.gestionpedidos.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {
    private Integer id;            // Identificador único del pedido.
    private String codigo;         // Código del pedido.
    private String fecha;          // Fecha del pedido.
    private Integer usuarioId;     // Identificador del usuario que realizó el pedido.
    private Integer total;         // Total del pedido.
    private ArrayList<Item> items = new ArrayList<>();  // Lista de ítems asociados al pedido.
}
