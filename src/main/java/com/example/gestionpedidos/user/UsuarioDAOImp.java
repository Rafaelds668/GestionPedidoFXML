/**
 * La clase UsuarioDAOImp es una implementación de la interfaz UsuarioDAO y se encarga de interactuar con la base de datos
 * para gestionar usuarios en una aplicación de gestión de pedidos.
 *
 * Esta clase proporciona la implementación del método para cargar un usuario por su dirección de correo electrónico y contraseña desde la base de datos.
 *
 * @author com.example.gestionpedidos.user
 * @version 1.0
 */
package com.example.gestionpedidos.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOImp implements UsuarioDAO {

    private final Connection connection;
    private final static String loadUserByEmail = "SELECT * FROM usuario WHERE email = ?";

    /**
     * Constructor para la clase UsuarioDAOImp.
     *
     * @param conn La conexión a la base de datos que se utilizará para las operaciones de carga de usuarios.
     */
    public UsuarioDAOImp(Connection conn) {
        this.connection = conn;
    }

    /**
     * Carga un usuario desde la base de datos utilizando su dirección de correo electrónico y contraseña.
     *
     * @param email La dirección de correo electrónico del usuario.
     * @param contrasenya La contraseña del usuario.
     * @return El objeto Usuario que representa al usuario cargado, o lanza una excepción si las credenciales son incorrectas o el usuario no se encuentra.
     * @throws RuntimeException Si ocurre un error al interactuar con la base de datos.
     */
    @Override
    public Usuario loadUser(String email, String contrasenya) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loadUserByEmail);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasenya(resultSet.getString("contrasenya"));
                if (!contrasenya.equals(usuario.getContrasenya())) {
                    throw new Exception("Contraseña incorrecta");
                } else {
                    return usuario;
                }
            } else {
                throw new RuntimeException("Usuario incorrecto");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
