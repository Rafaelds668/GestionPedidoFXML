/**
 * La interfaz ProductoDAO define los métodos que deben implementarse para interactuar con la base de datos y gestionar
 * productos en una aplicación de gestión de pedidos.
 *
 * Esta interfaz proporciona un contrato que incluye un método para cargar un producto específico por su identificador.
 *
 * @author com.example.gestionpedidos.products
 * @version 1.0
 */
package com.example.gestionpedidos.products;

public interface ProductoDAO {

    /**
     * Carga un producto específico de la base de datos utilizando su identificador.
     *
     * @param id El identificador del producto que se desea cargar.
     * @return El objeto Producto que representa el producto cargado.
     */
    public Producto loadProduct(Integer id);
}
