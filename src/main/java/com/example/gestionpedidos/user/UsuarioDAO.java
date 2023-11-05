/**
 * La interfaz UsuarioDAO define los métodos que deben implementarse para interactuar con la base de datos y gestionar
 * usuarios en una aplicación de gestión de pedidos.
 *
 * Esta interfaz proporciona un contrato que incluye un método para cargar un usuario por su dirección de correo electrónico
 * y contraseña.
 *
 * @author com.example.gestionpedidos.user
 * @version 1.0
 */
package com.example.gestionpedidos.user;

public interface UsuarioDAO {

    /**
     * Carga un usuario desde la base de datos utilizando su dirección de correo electrónico y contraseña.
     *
     * @param email La dirección de correo electrónico del usuario.
     * @param contrasenya La contraseña del usuario.
     * @return El objeto Usuario que representa al usuario cargado, o null si no se encontró un usuario con las credenciales proporcionadas.
     */
    public Usuario loadUser(String email, String contrasenya);
}
