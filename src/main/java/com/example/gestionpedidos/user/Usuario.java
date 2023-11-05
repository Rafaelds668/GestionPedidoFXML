/**
 * La clase Usuario representa un usuario en una aplicación de gestión de pedidos. Cada usuario contiene información
 * sobre su identificador, nombre, contraseña, dirección de correo electrónico y una lista de pedidos asociados.
 *
 * Esta clase es serializable y utiliza anotaciones de Lombok para simplificar la creación de constructores y métodos getter y setter.
 *
 * @author com.example.gestionpedidos.user
 * @version 1.0
 */
package com.example.gestionpedidos.user;

import com.example.gestionpedidos.orders.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    private Integer id;          // Identificador único del usuario.
    private String nombre;       // Nombre del usuario.
    private String contrasenya;  // Contraseña del usuario.
    private String email;        // Dirección de correo electrónico del usuario.
    private ArrayList<Pedido> pedidos;  // Lista de pedidos asociados al usuario.
}
