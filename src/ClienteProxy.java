
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
public class ClienteProxy implements InterfazCliente {

    /**
    * Cliente real al que hace referencia el proxy
    */
    private Cliente clienteReal;

    /**
    * Carrito de compras de un solo artículo del cliente
    */
    private Producto carritoCompra;

    /**
    * Constructor del proxy de un cliente
    *
    * @param clienteReal Cliente al que se refiere el proxy
    */
    public ClienteProxy(Cliente clienteReal){
        this.clienteReal = clienteReal;
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
    * @return Único producto en el carrito
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
    * Devuelve el teléfono del cliente
    *
    * @return Cadena con el teléfono del cliente
    */
    public String getTelefono(){
        return clienteReal.getTelefono();
    }

    /**
    * Devuelve la dirección del cliente
    *
    * @return Cadena con la dirección del cliente
    */
    public String getDireccion(){
        return clienteReal.getDireccion();
    }

    /**
    * Devuelve el país de origen del cliente
    *
    * @return Cadena con el país de origen del cliente
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
    * Devuelve la promoción que aplica para el cliente
    *
    * @return Cadena con la promoción dirigida al cliente
    */
    public String getPromocion(){
        return clienteReal.getPromocion();
    }

    /**
     * Método para obtener el saldo del cliente
     *
     * @return saldo - Saldo del cliente
     */
    public double getSaldo(){
        return clienteReal.getSaldo();
    }

    /**
     * Método para cambiar el saldo del cliente
     *
     * @return saldo - Saldo del cliente
     */
    public void setSaldo(double saldo){
        clienteReal.setSaldo(saldo);
    }
}
