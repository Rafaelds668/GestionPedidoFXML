/**
 * La clase VentanaUsuarioController es responsable de controlar la ventana del usuario en una aplicación JavaFX.
 * Interactúa con la base de datos para cargar y mostrar los pedidos del usuario, y permite al usuario cerrar sesión o ver los detalles de un pedido seleccionado.
 *
 * Esta clase utiliza componentes FXML de JavaFX, como botones, etiquetas y una tabla, para lograr sus funcionalidades.
 *
 * @author com.example.gestionpedidos.controllers
 * @version 1.0
 */
package com.example.gestionpedidos.controllers;

import com.example.gestionpedidos.Main;
import com.example.gestionpedidos.Sesion;
import com.example.gestionpedidos.domain.DBConnection;
import com.example.gestionpedidos.orders.Pedido;
import com.example.gestionpedidos.orders.PedidoDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaUsuarioController implements Initializable {
    @javafx.fxml.FXML
    private Button btnCerrarSesion;
    @javafx.fxml.FXML
    private Label labelTitulo;
    @javafx.fxml.FXML
    private TableView<Pedido> tvPedidos;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colIdPedido;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colCodPedido;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colFecha;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colUsuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colTotal;

    private ObservableList<Pedido> pedidosObservable;

    /**
     * Constructor predeterminado para la clase VentanaUsuarioController.
     */
    public VentanaUsuarioController(){}

    /**
     * Inicializa la clase VentanaUsuarioController y configura las columnas de la tabla de pedidos.
     *
     * @param url            La ubicación para resolver el objeto raíz o null si la ubicación no se conoce.
     * @param resourceBundle Los recursos a utilizar en este método de inicialización, o null si el objeto raíz no se definió.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colIdPedido.setCellValueFactory((fila) ->{
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });
        this.colFecha.setCellValueFactory((fila) ->{
            String fecha = String.valueOf(fila.getValue().getFecha());
            return new SimpleStringProperty(fecha);
        });
        this.colCodPedido.setCellValueFactory((fila) -> {
            String codigoPedido = fila.getValue().getCodigo();
            return new SimpleStringProperty(codigoPedido);
        });
        this.colUsuario.setCellValueFactory((fila) -> {
            String usuarioId = String.valueOf(fila.getValue().getUsuarioId());
            return new SimpleStringProperty(usuarioId);
        });
        this.colTotal.setCellValueFactory((fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });

        this.labelTitulo.setText("Bienvenido, " + Sesion.getUsuario().getNombre());
        this.pedidosObservable = FXCollections.observableArrayList();
        PedidoDAOImp pedidoDAOImp = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(pedidoDAOImp.loadAll(Sesion.getUsuario().getId()));
        this.pedidosObservable.addAll(Sesion.getPedidos());
        this.tvPedidos.setItems(this.pedidosObservable);
        this.tvPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            this.seleccionarPedido(this.tvPedidos.getSelectionModel().getSelectedItem());
        });
    }

    private void seleccionarPedido(Pedido pedido) {
        Sesion.setPedido(pedido);
        Sesion.setPos(this.tvPedidos.getSelectionModel().getSelectedIndex());
        Main.loadFXMLDetalles("ventana-pedido.fxml");
    }

    /**
     * Método para cerrar la sesión del usuario y cargar la ventana de inicio de sesión.
     *
     * @param actionEvent El evento desencadenado al hacer clic en el botón de cerrar sesión.
     */
    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent){
        Sesion.setUsuario(null);
        Main.loadFXMLLogin("ventana-login.fxml");
    }
}
