module com.example.gestiondepedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.gestionpedidos to javafx.fxml;
    exports com.example.gestionpedidos;
    exports com.example.gestionpedidos.controllers;
    opens com.example.gestionpedidos.controllers to javafx.fxml;
    exports com.example.gestionpedidos.orders;
    opens com.example.gestionpedidos.orders to javafx.fxml;
    exports com.example.gestionpedidos.item;
    opens com.example.gestionpedidos.item to javafx.fxml;
}