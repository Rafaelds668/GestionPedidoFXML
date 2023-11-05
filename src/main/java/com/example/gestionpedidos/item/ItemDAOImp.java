/**
 * La clase ItemDAOImp es una implementación de la interfaz ItemDAO y se encarga de interactuar con la base de datos
 * para gestionar ítems en una aplicación de gestión de pedidos.
 *
 * Esta clase proporciona la implementación del método para cargar todos los ítems asociados a un pedido en la base de datos.
 *
 * @author com.example.gestionpedidos.item
 * @version 1.0
 */
package com.example.gestionpedidos.item;

import com.example.gestionpedidos.domain.DBConnection;
import com.example.gestionpedidos.products.Producto;
import com.example.gestionpedidos.products.ProductoDAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImp implements ItemDAO {
    private static Connection connection;
    private static final String queryLoadAll = "select * from item where codigo_pedido = ?";

    /**
     * Constructor para la clase ItemDAOImp.
     *
     * @param conn La conexión a la base de datos que se utilizará para las operaciones de carga de ítems.
     */
    public ItemDAOImp(Connection conn) {
        this.connection = conn;
    }

    /**
     * Carga todos los ítems asociados a un pedido en la base de datos.
     *
     * @param codigo_Pedido El identificador o código del pedido del cual se cargarán los ítems.
     * @return Una lista de objetos Item que representan los ítems asociados al pedido.
     * @throws RuntimeException Si ocurre un error al interactuar con la base de datos.
     */
    @Override
    public ArrayList<Item> loadAll(String codigo_Pedido) {
        ArrayList<Item> salida = new ArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            preparedStatement.setString(1, codigo_Pedido);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setCodigo_pedido(resultSet.getString("codigo_pedido"));
                Integer productId = resultSet.getInt("producto_id");
                item.setCantidad(resultSet.getInt("cantidad"));
                ProductoDAOImp productoDAOImp = new ProductoDAOImp(DBConnection.getConnection());
                Producto producto = productoDAOImp.loadProduct(productId);
                item.setProducto_id(producto);
                salida.add(item);
            }

            return salida;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
