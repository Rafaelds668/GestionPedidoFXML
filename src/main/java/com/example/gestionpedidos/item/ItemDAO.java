/**
 * La interfaz ItemDAO define los métodos que deben implementarse para interactuar con la base de datos y gestionar
 * ítems en una aplicación de gestión de pedidos.
 *
 * Esta interfaz proporciona un contrato que incluye un método para cargar todos los ítems asociados a un pedido.
 *
 * @author com.example.gestionpedidos.item
 * @version 1.0
 */
package com.example.gestionpedidos.item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {

    /**
     * Carga todos los ítems asociados a un pedido en la base de datos.
     *
     * @param var El identificador o código del pedido del cual se cargarán los ítems.
     * @return Una lista de objetos Item que representan los ítems asociados al pedido.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    ArrayList<Item> loadAll(String var) throws SQLException;
}
