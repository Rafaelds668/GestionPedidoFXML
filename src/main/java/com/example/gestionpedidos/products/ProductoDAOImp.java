/**
 * La clase ProductoDAOImp es una implementación de la interfaz ProductoDAO y se encarga de interactuar con la base de datos
 * para gestionar productos en una aplicación de gestión de pedidos.
 *
 * Esta clase proporciona la implementación del método para cargar un producto específico por su identificador desde la base de datos.
 *
 * @author com.example.gestionpedidos.products
 * @version 1.0
 */
package com.example.gestionpedidos.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAOImp implements ProductoDAO {
    private static Connection connection;
    private static String queryLoadAll = "select * from producto where id=?";

    /**
     * Constructor para la clase ProductoDAOImp.
     *
     * @param conn La conexión a la base de datos que se utilizará para las operaciones de carga de productos.
     */
    public ProductoDAOImp(Connection conn) {
        connection = conn;
    }

    /**
     * Carga un producto específico de la base de datos utilizando su identificador.
     *
     * @param id El identificador del producto que se desea cargar.
     * @return El objeto Producto que representa el producto cargado, o null si no se encontró un producto con el identificador dado.
     * @throws RuntimeException Si ocurre un error al interactuar con la base de datos.
     */
    @Override
    public Producto loadProduct(Integer id) {
        Producto producto = null;
        try {
            // Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCantidad_disponible(resultSet.getInt("cantidad_disponible"));
            }

            return producto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
