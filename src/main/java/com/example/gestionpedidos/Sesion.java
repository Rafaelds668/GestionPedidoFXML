
package com.example.gestionpedidos;

import com.example.gestionpedidos.item.Item;
import com.example.gestionpedidos.orders.Pedido;
import com.example.gestionpedidos.products.Producto;
import com.example.gestionpedidos.user.Usuario;

import java.util.ArrayList;

/**
 * La clase Sesion representa la sesión actual de usuario en una aplicación de gestión de pedidos. Almacena información sobre
 * el usuario actual, el pedido actual y listas de pedidos, productos e items asociados a la sesión.
 *
 * Esta clase proporciona métodos para acceder y modificar la información de la sesión.
 *
 * @author com.example.gestionpedidos
 * @version 1.0
 */
public class Sesion {
    private static Integer pos = null;                 // Posición actual en una lista (por ejemplo, lista de pedidos).
    private static Usuario usuario;                   // Usuario actual en la sesión.
    private static Pedido pedido;                     // Pedido actual en la sesión.
    private static ArrayList<Pedido> pedidos = new ArrayList();     // Lista de pedidos asociados a la sesión.
    private static ArrayList<Producto> productos = new ArrayList();  // Lista de productos asociados a la sesión.
    private static ArrayList<Item> items = new ArrayList();         // Lista de items asociados a la sesión.

    /**
     * Constructor de la clase Sesion.
     */
    public Sesion() {
    }

    /**
     * Obtiene la posición actual en una lista (por ejemplo, lista de pedidos).
     *
     * @return La posición actual en la lista.
     */
    public static Integer getPos() {
        return pos;
    }

    /**
     * Establece la posición actual en una lista (por ejemplo, lista de pedidos).
     *
     * @param pos La nueva posición en la lista.
     */
    public static void setPos(Integer pos) {
        Sesion.pos = pos;
    }

    /**
     * Obtiene el pedido actual en la sesión.
     *
     * @return El pedido actual.
     */
    public static Pedido getPedido() {
        return pedido;
    }

    /**
     * Establece el pedido actual en la sesión.
     *
     * @param pedido El nuevo pedido actual.
     */
    public static void setPedido(Pedido pedido) {
        Sesion.pedido = pedido;
    }

    /**
     * Obtiene el usuario actual en la sesión.
     *
     * @return El usuario actual.
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario actual en la sesión.
     *
     * @param usuario El nuevo usuario actual.
     */
    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

    /**
     * Obtiene la lista de pedidos asociados a la sesión.
     *
     * @return La lista de pedidos.
     */
    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Establece la lista de pedidos asociados a la sesión.
     *
     * @param pedidos La nueva lista de pedidos.
     */
    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Sesion.pedidos = pedidos;
    }

    /**
     * Obtiene la lista de productos asociados a la sesión.
     *
     * @return La lista de productos.
     */
    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos asociados a la sesión.
     *
     * @param productos La nueva lista de productos.
     */
    public static void setProductos(ArrayList<Producto> productos) {
        Sesion.productos = productos;
    }

    /**
     * Obtiene la lista de items asociados a la sesión.
     *
     * @return La lista de items.
     */
    public static ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Establece la lista de items asociados a la sesión.
     *
     * @param items La nueva lista de items.
     */
    public static void setItems(ArrayList<Item> items) {
        Sesion.items = items;
    }
}
