/**
 * La interfaz PedidoDAO define los métodos que deben implementarse para interactuar con la base de datos y gestionar
 * pedidos en una aplicación de gestión de pedidos.
 *
 * Esta interfaz proporciona un contrato que incluye un método para cargar todos los pedidos asociados a un usuario.
 *
 * @author com.example.gestionpedidos.orders
 * @version 1.0
 */
package com.example.gestionpedidos.orders;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PedidoDAO {

    /**
     * Carga todos los pedidos asociados a un usuario en la base de datos.
     *
     * @param id El identificador del usuario del cual se cargarán los pedidos.
     * @return Una lista de objetos Pedido que representan los pedidos asociados al usuario.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public ArrayList<Pedido> loadAll(Integer id) throws SQLException;
}
