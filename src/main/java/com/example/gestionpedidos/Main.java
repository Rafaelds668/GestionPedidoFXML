/**
 * La clase Main es la clase principal de la aplicación de gestión de pedidos. Es una subclase de javafx.application.Application
 * y se encarga de iniciar y gestionar la interfaz de usuario de la aplicación.
 *
 * Esta clase carga ventanas FXML y gestiona la transición entre las distintas vistas de la aplicación.
 *
 * @author com.example.gestionpedidos
 * @version 1.0
 */
package com.example.gestionpedidos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    // Representa la ventana principal de la aplicación.
    private static Stage myStage;

    /**
     * Método de inicio de la aplicación. Configura la ventana principal y carga la vista de inicio.
     *
     * @param stage El objeto Stage que representa la ventana principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar la vista FXML de inicio.
     */
    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ventana-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setResizable(false);
        stage.setTitle("Gestión de pedidos");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Carga una vista FXML relacionada con el usuario y la muestra en la ventana principal.
     *
     * @param s La ruta de la vista FXML que se cargará.
     */
    public static void loadFXMLUsuario(String s) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(s));
            Scene scene = new Scene(fxmlLoader.load(), 850, 600);
            myStage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga una vista FXML de detalles y la muestra en la ventana principal.
     *
     * @param ruta La ruta de la vista FXML de detalles que se cargará.
     */
    public static void loadFXMLDetalles(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            myStage.setScene(scene);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3);
        }
    }

    /**
     * Carga una vista FXML de inicio de sesión y la muestra en la ventana principal.
     *
     * @param ruta La ruta de la vista FXML de inicio de sesión que se cargará.
     */
    public static void loadFXMLLogin(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            myStage.setScene(scene);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    /**
     * Método principal para iniciar la aplicación.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        launch();
    }
}
