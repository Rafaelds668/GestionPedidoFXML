/**
 * La clase LoginController es responsable de gestionar la autenticación de usuarios y controlar la vista de inicio de sesión
 * en una aplicación JavaFX. Interactúa con una base de datos para validar las credenciales del usuario y, en caso de una autenticación exitosa,
 * navega a un panel de usuario.
 *
 * Esta clase incluye componentes FXML de JavaFX para el nombre de usuario, la contraseña, el botón de inicio de sesión y una etiqueta de información.
 *
 * @author com.example.gestionpedidos.controllers
 * @version 1.0
 */
package com.example.gestionpedidos.controllers;

import com.example.gestionpedidos.Main;
import com.example.gestionpedidos.Sesion;
import com.example.gestionpedidos.domain.DBConnection;
import com.example.gestionpedidos.user.Usuario;
import com.example.gestionpedidos.user.UsuarioDAOImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Serializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnIniciar;
    @FXML
    private Label info;

    /**
     * Constructor predeterminado para la clase LoginController.
     */
    public LoginController(){}

    /**
     * Método de inicialización para LoginController, requerido por JavaFX.
     *
     * @param url            La ubicación para resolver el objeto raíz o null si la ubicación no se conoce.
     * @param resourceBundle Los recursos a utilizar en este método de inicialización, o null si el objeto raíz no se definió.
     */
    public void initialize(URL url, ResourceBundle resourceBundle){}

    /**
     * Método controlador de eventos para la acción de hacer clic en el botón de inicio de sesión. Intenta autenticar al usuario
     * comprobando el nombre de usuario y la contraseña proporcionados en la base de datos.
     *
     * @param actionEvent El evento desencadenado al hacer clic en el botón de inicio de sesión.
     */
    @FXML
    public void login(ActionEvent actionEvent) {
        String user = txtUser.getText();
        String password = txtPassword.getText();
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(DBConnection.getConnection());

        // Intento de cargar al usuario desde la base de datos
        try{
            Usuario usuario= usuarioDAOImp.loadUser(user, password);
            Sesion.setUsuario(usuario);
            Main.loadFXMLUsuario("ventana-usuario.fxml");
        } catch (Exception e) {
            info.setText("Datos incorrectos, vuelva a introducirlos");
            info.setTextFill(Color.RED);
            throw new RuntimeException(e);
        }
    }
}
