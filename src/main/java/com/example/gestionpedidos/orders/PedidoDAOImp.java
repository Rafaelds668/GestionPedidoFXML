/**
 * La clase PedidoDAOImp es una implementación de la interfaz PedidoDAO y se encarga de interactuar con la base de datos
 * para gestionar pedidos en una aplicación de gestión de pedidos.
 *
 * Esta clase proporciona la implementación del método para cargar todos los pedidos asociados a un usuario en la base de datos.
 *
 * @author com.example.gestionpedidos.orders
 * @version 1.0
 */
package com.example.gestionpedidos.orders;

import com.example.gestionpedidos.Sesion;
import com.example.gestionpedidos.domain.DBConnection;
import com.example.gestionpedidos.item.ItemDAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PedidoDAOImp implements PedidoDAO {
    private static Connection connection;
    private final static String queryLoadAll = "select * from pedido where usuario = ?";

    /**
     * Constructor para la clase PedidoDAOImp.
     *
     * @param conn La conexión a la base de datos que se utilizará para las operaciones de carga de pedidos.
     */
    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }

    /**
     * Carga todos los pedidos asociados a un usuario en la base de datos.
     *
     * @param id El identificador del usuario del cual se cargarán los pedidos.
     * @return Una lista de objetos Pedido que representan los pedidos asociados al usuario.
     * @throws RuntimeException Si ocurre un error al interactuar con la base de datos.
     */
    public ArrayList<Pedido> loadAll(Integer id) {
        ArrayList<Pedido> salida = new ArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getInt("id"));
                pedido.setCodigo(resultSet.getString("codigo"));
                pedido.setFecha((new SimpleDateFormat("yyyy-MM-dd")).format(resultSet.getDate("fecha")));
                pedido.setUsuarioId(resultSet.getInt("usuario"));
                pedido.setTotal(resultSet.getInt("total"));
                pedido.setItems(itemDAOImp.loadAll(pedido.getCodigo()));
                Sesion.setPedido(pedido);
                salida.add(pedido);
            }

            return salida;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
