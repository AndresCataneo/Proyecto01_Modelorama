
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
    Idioma idioma;

    /**
    * Lista de los clientes
    */
    ArrayList<ClienteProxy> listaClientes;

    /**
    * Cliente con sesion iniciada en la tienda
    */
    ClienteProxy sesion;

    /**
    * Booleano que indica si hay oferta en México
    */
    boolean ofertaMexico = false;

    /**
    * Booleano que indica si hay oferta en EUA
    */
    boolean ofertaEUA = false;

    /**
    * Booleano que indica si hay oferta en España
    */
    boolean ofertaEspana = false;

    /**
    * Entero que indica el descuento que tendrán
    * los productos de cierto departamento, dependiendo
    * del país de origen del cliente
    */
    int oferta = 0;

    /**
     * Constructor de la clase Tienda
     *
     */
    public Tienda(){
        descargarClientes();
        generaOferta();
        ofertaPaises();
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
    public void catalogo(){
        Catalogo catalogo = Catalogo.getInstance(); //provisional
        System.out.println(catalogo.informacion());
    }

    /**
     * Metodo que le muestra al cliente el menu de compra en su respectivo idioma
     */
    public void menuCompra(){
        idioma.menuCompra();
    }

    /**
    * Agrega un producto al carrito del cliente a partir de su codigo de barras
    *
    * @param codigoBarras Codigo de barras del producto a agregar
    */
    public void agregarAlCarrito(int codigoBarras){
        if (sesion.getCarrito() != null) {
            System.out.println("UN PRODUCTO A LA VEZ. Ya hay un producto en el carrito.");
            return ;
        }
        Catalogo catalogo = Catalogo.getInstance();
        Producto aComprar = catalogo.getProducto(codigoBarras);
        sesion.agregarAlCarrito(aComprar);
    }

    /**
     * Metodo para que el clienta pague su producto
     */
    public void pagar(){
        Producto producto = sesion.getCarrito();
        if (producto != null) {
            compraSegura();
            //ticketCompra();
            sesion.vaciarCarrito();
        }
    }

    /**
    * Pantalla de compra segura para verificar los datos
    * de la cuenta bancaria del cliente
    */
    private void compraSegura(){
        Scanner scn = new Scanner(System.in);
        System.out.println("*****COMPRA SEGURA*****");
        System.out.println("Para su seguridad necesitamos que ingrese " +
                            "su número de cuenta bancaria");
        System.out.println("Solo tienes dos oportunidades");
        String numCuentaBanco = scn.nextLine();
        if (!sesion.compraSegura(numCuentaBanco)) {
            System.out.println("El número de cuenta bancaria no coincidio");
            System.out.println("Vuelve a intentarlo, es tu último intento");
            numCuentaBanco = scn.nextLine();
            if (!sesion.compraSegura(numCuentaBanco)) {
                System.out.println("Eso es todo. No te apures, la " +
                                    "policía ya esta en camino");
                System.exit(1);
            }
        }
        System.out.println("Transacción exitosa");
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
        listaClientes.add(clienteProxy);
    }

    /**
     * Metodo para eliminar un cliente de la lista de clientes
     *
     * @param cliente Cliente que se va a eliminar
     */
    public void quitarObservador(Cliente cliente){
        ClienteProxy clienteProxy = new ClienteProxy(cliente);
        listaClientes.remove(clienteProxy);
    }

    /**
     * Metodo para notificar a los clientes de una oferta
     *
     * @param oferta Oferta que se va a notificar
     */
    public void notificarObservador(String mensaje){
        for(ClienteProxy cliente : listaClientes){
            cliente.actualizar(mensaje);
        }
    }

    /**
    * Descarga desde el servidor la lista de clientes
    */
    private void descargarClientes(){
        try {
            Socket s = new Socket("localhost", 8080);
            RemoteMessagePassing rmp = new RemoteMessagePassing(s);
            rmp.send("descargarClientes");
            listaClientes = (ArrayList<ClienteProxy>) rmp.receive();
            rmp.close();
        } catch(Exception e) {
            System.out.println("El servidor de la tienda no esta en linea");
            System.out.println("En otra terminal ejecuta \"java Main servidor\"");
            System.exit(1);
        }
    }

    /**
    * Cierra el servidor de la tienda
    */
    public void cerrarServidor(){
        try {
            Socket s = new Socket("localhost", 8080);
            RemoteMessagePassing rmp = new RemoteMessagePassing(s);
            rmp.send("cerrarServidor");
            rmp.close();
        } catch(Exception e) {

        }
    }

    /**
    * Inicia sesion en la tienda, si los datos son correctos
    *
    * @param nombreUsuario Nombre de usuario para iniciar sesión
    * @param contrasena Constraseña para intentar iniciar sesión
    */
    public void iniciarSesion(String nombreUsuario, String contrasena){
        for (ClienteProxy cp : listaClientes) {
            if (cp.inicioSesion(nombreUsuario, contrasena)) {
                sesion = cp;
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
    * Devuelve la oferta que aplica para el usuario y producto
    * que este esta comprando
    *
    * @return Oferta aplicable dependiendo del cliente y producto a comprar
    */
    private int getOferta(){
        Producto aComprar = sesion.getCarrito();
        String depaProducto = aComprar.getNombreDepartamento();
        if ("Mexico".equals(sesion.getPais()) && ofertaMexico && "".equals(depaProducto)) {
            return oferta;
        } else if ("EUA".equals(sesion.getPais()) && ofertaEUA && "".equals(depaProducto)) {
            return oferta;
        } else if ("España".equals(sesion.getPais()) && ofertaEspana && "".equals(depaProducto)) {
            return oferta;
        }
        return 0;
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

}
