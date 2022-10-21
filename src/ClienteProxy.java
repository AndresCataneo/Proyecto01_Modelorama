
import java.io.Serializable;

/**
* Clase que simula el proxy de un cliente de CheemsMart.
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public class ClienteProxy implements Serializable, InterfazCliente {

    /**
    * Cliente real al que hace referencia el proxy
    */
    private Cliente clienteReal;

    /**
    * Carrito de compras de un solo articulo del cliente
    */
    private Producto carritoCompra;

    /**
    * Cadena con la promocion que puede aprovechar el cliente
    */
    private String promocion;

    /**
    * Constructor del proxy de un cliente
    *
    * @param clienteReal Cliente al que se refiere el proxy
    */
    public ClienteProxy(Cliente clienteReal){
        this.clienteReal = clienteReal;
    }

    @Override
    public boolean inicioSesion(String nombreUsuario, String contrasena){
        return clienteReal.inicioSesion(nombreUsuario, contrasena);
    }

    @Override
    public boolean compraSegura(String cuentaBanco){
        return clienteReal.compraSegura(cuentaBanco);
    }

    /**
    * Agrega un producto al carrito del cliente
    *
    * @param producto Producto a agregar al carrito
    */
    public void agregarAlCarrito(Producto producto){
        this.carritoCompra = producto;
    }

    /**
    * Devuelve el producto en el carrito de compra del cliente
    *
    * @return Unico producto en el carrito
    */
    public Producto getCarrito(){
        return carritoCompra;
    }

    /**
    * Vacia el carrito de compra, quita el producto
    */
    public void vaciarCarrito(){
        this.carritoCompra = null;
    }

    /**
    * Devuelve el nombre del cliente
    *
    * @return Cadena con el nombre del cliente
    */
    public String getNombre(){
        return clienteReal.getNombre();
    }

    /**
    * Devuelve el telefono del cliente
    *
    * @return Cadena con el telefono del cliente
    */
    public String getTelefono(){
        return clienteReal.getTelefono();
    }

    /**
    * Devuelve la direccion del cliente
    *
    * @return Cadena con la direccion del cliente
    */
    public String getDireccion(){
        return clienteReal.getDireccion();
    }

    /**
    * Devuelve el pais de origen del cliente
    *
    * @return Cadena con el pais de origen del cliente
    */
    public String getPais(){
        return clienteReal.getPais();
    }

    /**
    * Devuelve el ID del cliente
    *
    * @return Long con el ID del cliente
    */
    public long getID(){
        return clienteReal.getID();
    }

    /**
    * Actualiza la información de promocion que puede
    * aprovechar el cliente
    *
    * @param promocion Nueva promocion para el cliente
    */
    public void actualizarPromocion(String promocion){
        this.promocion = promocion;
    }

    /**
    * Devuelve la promocion que aplica para el cliente
    *
    * @return Cadena con la promocion dirigida al cliente
    */
    public String getPromocion(){
        return promocion;
    }
}
