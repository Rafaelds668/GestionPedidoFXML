/**
 * La clase DBConnection se encarga de establecer una conexión con la base de datos utilizando la configuración
 * proporcionada en un archivo de propiedades llamado "bbdd.properties". La conexión se mantiene como un recurso compartido
 * para ser utilizada por otras clases que requieran acceso a la base de datos.
 *
 * Esta clase carga la configuración de la base de datos desde el archivo "bbdd.properties" y utiliza esos datos para
 * establecer una conexión con la base de datos MySQL.
 *
 * @author com.example.gestionpedidos.domain
 * @version 1.0
 */
package com.example.gestionpedidos.domain;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection connection;
    private static Logger logger = Logger.getLogger(DBConnection.class.getName());

    /**
     * Constructor predeterminado para la clase DBConnection.
     */
    public DBConnection(){}

    static {
        String url;
        String user;
        String password;

        Properties properties = new Properties();

        try{
            // Cargar la configuración de la base de datos desde el archivo "bbdd.properties".
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("bbdd.properties");
            properties.load(inputStream);
            // Construir la URL de conexión a la base de datos.
            url = "jdbc:mysql://" + properties.get("host") + ":" + properties.get("port") + "/" + properties.get("dbname");
            user = (String) properties.get("user");
            password = (String) properties.get("pass");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            // Establecer la conexión con la base de datos utilizando la URL, nombre de usuario y contraseña proporcionados.
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public static Connection getConnection(){
        return connection;
    }
}
