import java.util.ArrayList;
/**
 * Clase que simula una tienda de distintos tipos de productos.
 * 
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class Tienda implements Sujeto{

    Idioma idioma;

    ArrayList<ClienteProxy> listaDeClientes;

    ClienteProxy sesion;

    boolean ofertaMexico;

    boolean ofertaEUA;

    boolean ofertaEspana;

    int descuento;

    /**
     * Constructor de la clase Tienda
     * 
     */
    public Tienda(){
        listaDeClientes = new ArrayList<ClienteProxy>();
        ofertaMexico = false;
        ofertaEUA = false;
        ofertaEspana = false;
        descuento = 0;
    }

    /**
     * Metodo que da la bienvendiada al cliente en su respectivo idioma
     */
    public void saludar(){
        idioma.saludar();
    }

    /**
     * Metodo que le muestra al cliente el menu inicial en su respectivo idioma
     */    
    public void menuInicial(){
        idioma.menuInicial();
    }

    /**
     * Metodo que le muestra al cliente el catalogo con los productos en el idioma regional
     */
    public void catalogo(Catalogo catalogo){
        catalogo.informacion();
        idioma.menuCompra();
    }

    /**
     * Metodo para que el clienta compre un producto
     */
    public void pagar(){
        Producto producto = sesion.getCarrito();
        double precioCompra = 0;
        boolean precio = false;

        if(producto != null){
            precioCompra = producto.getPrecio();

            if(ofertaMexico){
                precioCompra = precioCompra - ((precioCompra * descuento) / 100);
            }else if(ofertaEUA){
                precioCompra = precioCompra - ((precioCompra * descuento) / 100);
            }else if(ofertaEspana){
                precioCompra = precioCompra - ((precioCompra * descuento) / 100);
            }

            precio = true;
        }

        idioma.hayProducto(precio, precioCompra); 

        //Aun está incompleto
    }

    /**
     * Metodo que le muestra al cliente el ticket de compra en su respectivo idioma
     * 
     * @param listaProductos Lista de productos que el cliente ha comprado
     */
    public void ticketCompra(ArrayList<Producto> listaProductos){
        idioma.ticketCompra(listaProductos);
    }

    public void getFechaCompra(){
        idioma.fechaEntrega();
    }

    /**
     * Metodo que da la despedida al cliente en su respectivo idioma
     */
    public void despedirse(){
        idioma.despedirse();
    }

    /**
     * Metodo para registrar un cliente y poder enviarle notificaciones
     * 
     * @param cliente Cliente que se va a registrar
     */
    public void registrarObservador(Cliente cliente){
        ClienteProxy clienteProxy = new ClienteProxy(cliente);
        listaDeClientes.add(clienteProxy);
    }

    /**
     * Metodo para eliminar un cliente de la lista de clientes
     * 
     * @param cliente Cliente que se va a eliminar
     */
    public void quitarObservador(Cliente cliente){
        ClienteProxy clienteProxy = new ClienteProxy(cliente);
        listaDeClientes.remove(clienteProxy);
    }

    /**
     * Metodo para notificar a los clientes de una oferta
     * 
     * @param oferta Oferta que se va a notificar
     */
    public void notificarObservador(String mensaje){
        for(ClienteProxy cliente : listaDeClientes){
            cliente.actualizar(mensaje);
        }
    }

    
}
