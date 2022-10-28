
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.net.*;
import java.io.*;

/**
 * Clase que simula una tienda de distintos tipos de productos.
 *
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class Tienda implements Sujeto{

    /**
    * Idioma de la tienda adecuado para el cliente
    */
    private Idioma idioma;

    /**
    * Lista de los clientes
    */
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    /**
    * Cliente con sesion iniciada en la tienda
    */
    private ClienteProxy sesion;

    /**
    * Booleano que indica si hay oferta en México
    */
    private boolean ofertaMexico = false;

    /**
    * Booleano que indica si hay oferta en EUA
    */
    private boolean ofertaEUA = false;

    /**
    * Booleano que indica si hay oferta en España
    */
    private boolean ofertaEspana = false;

    /**
    * Entero que indica el descuento que tendrán
    * los productos de cierto departamento, dependiendo
    * del país de origen del cliente
    */
    private int oferta = 0;

    /**
     * Constructor de la clase Tienda
     *
     */
    public Tienda(){
        listaClientes.add(new Cliente("Gaelinho", "12345", "Gael Garcia", "5519032326", "N1 101", "GAG0210","Mexico", 10000, 1));
        listaClientes.add(new Cliente("RymerVS", "321", "Ryan", "5519032327", "N1 40", "XRX", "EUA", 1000,2));
        listaClientes.add(new Cliente("JosephEvil", "123", "Jose", "5519032328", "N1 50", "JOS", "España",3000, 3));
        generaOferta();
        ofertaPaises();
        notificarObservador();
    }

    /**
     * Metodo que da la bienvendiada al cliente en su respectivo idioma
     */
    public void saludar(){
        idioma.saludar();
        if (!"".equals(sesion.getPromocion())) {
            System.out.println(sesion.getPromocion() + "\n");
        }
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
    public void catalogo(){
        Catalogo catalogo = Catalogo.getInstance(); //provisional
        System.out.println(catalogo.informacion());
        System.out.println("$" + idioma.verSaldo(sesion)+ "\n");
    }

    /**
     * Metodo que le muestra al cliente el menu de compra en su respectivo idioma
     */
    public void menuCompra(){
        idioma.menuCompra();
    }

    /**
    * Agrega un producto al carrito del cliente a partir de su codigo de barras
    */
    public void agregarAlCarrito(){
        idioma.agregarAlCarrito(sesion);
    }

    /**
     * Metodo para que el clienta pague su producto
     */
    public void pagar(){
        Producto producto = sesion.getCarrito();
        if(producto != null && sesion.getSaldo() < producto.getPrecio()){
            idioma.mensajeAlerta(4);
            sesion.vaciarCarrito();
        }else if (producto != null) {
            idioma.compraSegura(sesion);
            ticketCompra();
            double precio = producto.getPrecio();
            if (aplicaOferta()) {
                precio = precio - (precio * (double) oferta / 100);
            }
            sesion.setSaldo(sesion.getSaldo() - precio);
            sesion.vaciarCarrito();
        }else{
            idioma.mensajeAlerta(2);
        }
    }

    /**
     * Metodo que le muestra al cliente el ticket de compra en su respectivo idioma
     */
    public void ticketCompra(){
        Producto comprado = sesion.getCarrito();
        System.out.println("******TICKET******\n");
        System.out.println(comprado.getNombre() + "\t-\t$" + comprado.getPrecio());
        System.out.println("Subtotal: $" + comprado.getPrecio());
        if (aplicaOferta()) {
            System.out.println(oferta + "% OFF");
            System.out.println("Total: $" + (comprado.getPrecio() - ((double) oferta / 100) * comprado.getPrecio()));
        } else {
            System.out.println("Total: $" + comprado.getPrecio());
        }
        getFechaCompra();
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
    * Mensaje de error al seleccionar una opcion
    */
    public void opcionInvalida(){
        idioma.opcionInvalida();
    }

    /**
     * Metodo para registrar un cliente y poder enviarle notificaciones
     *
     * @param cliente Cliente que se va a registrar
     */
    public void registrarObservador(Cliente cliente){
        ClienteProxy clienteProxy = new ClienteProxy(cliente);
        listaClientes.add(cliente);
    }

    /**
     * Metodo para eliminar un cliente de la lista de clientes
     *
     * @param cliente Cliente que se va a eliminar
     */
    public void quitarObservador(Cliente cliente){
        ClienteProxy clienteProxy = new ClienteProxy(cliente);
        listaClientes.remove(cliente);
    }

    /**
     * Metodo para notificar a los clientes de una oferta
     *
     * @param oferta Oferta que se va a notificar
     */
    public void notificarObservador(){
        for(Cliente cliente : listaClientes){
            String mensaje = "";
            if ("Mexico".equals(cliente.getPais()) && ofertaMexico) {
                mensaje = "Tienes " + oferta + "% de descuento ";
                mensaje += "en el departamento de alimenticios";
            } else if ("España".equals(cliente.getPais()) && ofertaEspana) {
                mensaje = "Tienes " + oferta + "% de promo ";
                mensaje += "en el departamento de electrodomésticos";
            } else if ("EUA".equals(cliente.getPais()) && ofertaEUA) {
                mensaje = "You have " + oferta + "% OFF ";
                mensaje += "in electronic department";
            }
            cliente.actualizar(mensaje);
        }
    }

    /**
    * Inicia sesion en la tienda, si los datos son correctos
    *
    * @param nombreUsuario Nombre de usuario para iniciar sesión
    * @param contrasena Constraseña para intentar iniciar sesión
    */
    public void iniciarSesion(String nombreUsuario, String contrasena){
        for (Cliente cp : listaClientes) {
            if (cp.inicioSesion(nombreUsuario, contrasena)) {
                sesion = new ClienteProxy(cp);
                if ("Mexico".equals(sesion.getPais())) {
                    idioma = new EspanolMexico();
                } else if ("España".equals(sesion.getPais())) {
                    idioma = new EspanolEspana();
                } else if ("EUA".equals(sesion.getPais())) {
                    idioma = new InglesEUA();
                }
                return ;
            }
        }
    }

    /**
    * Cierra la sesión actual de la tienda
    */
    public void cerrarSesion(){
        sesion = null;
    }

    /**
    * Indica si hay alguna sesión iniciada en la tienda
    *
    * @return   true    -   si hay una sesión iniciada
    *           false   -   si no hay sesión inciada
    */
    public boolean haySesionIniciada(){
        return sesion != null;
    }

    /**
    * Genera un descuento para aplicar a los departamentos
    *
    * @return Entero que representa un descuento en porcentaje
    */
    private void generaOferta(){
        Random rdm = new Random();

        int aleatorio = rdm.nextInt(100);
        if (aleatorio < 50) {
            oferta = 10;
        } else if (aleatorio >= 50 && aleatorio < 75) {
            oferta = 25;
        } else if (aleatorio >= 75 && aleatorio < 90) {
            oferta = 50;
        } else if (aleatorio >= 90 && aleatorio < 99) {
            oferta = 75;
        } else if (aleatorio == 99) {
            oferta = 100;
        }
    }

    /**
    * Decide pseudo-aleatoriamente que paises tienen ofertas
    */
    private void ofertaPaises(){
        Random rdm = new Random();
        int aleatorio = rdm.nextInt(7);

        switch (aleatorio) {
            case 0:
                ofertaMexico = true;
                break;
            case 1:
                ofertaEspana = true;
                break;
            case 2:
                ofertaEUA = true;
                break;
            case 3:
                ofertaMexico = true;
                ofertaEspana = true;
                break;
            case 4:
                ofertaMexico = true;
                ofertaEUA = true;
                break;
            case 5:
                ofertaEspana = true;
                ofertaEUA = true;
                break;
            case 6:
                ofertaMexico = true;
                ofertaEspana = true;
                ofertaEUA = true;
                break;
            default:
                break;
        }
    }

    /**
    * Indica si aplica la oferta
    *
    * @return   true    -   si aplica la oferta
    *           false   -   si no aplica
    */
    private boolean aplicaOferta(){
        Producto comprado = sesion.getCarrito();
        if (comprado == null) {
            return false;
        } else if("Mexico".equals(sesion.getPais()) && ofertaMexico
        && "Alimenticios".equals(comprado.getNombreDepartamento())) {
            return true;
        } else if ("Espana".equals(sesion.getPais()) && ofertaEspana
        && "Electrodomésticos".equals(comprado.getNombreDepartamento())) {
            return true;
        } else if ("EUA".equals(sesion.getPais()) && ofertaEUA
        && "Electrónica".equals(comprado.getNombreDepartamento())) {
            return true;
        }
        return false;
    }

    /**
     * Método que borrar el carrito del usuario en caso de cancelar
     * la compra
     */
    public void borrarCarrito(){
        Producto aBorrar = sesion.getCarrito();
        if(aBorrar != null){
            idioma.mensajeAlerta(3);
            sesion.vaciarCarrito();
        }
    }

}
