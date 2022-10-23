
import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
* Clase que simula el servidor de la tienda
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*/
public class Servidor {

    /**
    * Booleano que indica si el servidor esta en linea
    */
    private boolean enLinea;

    /**
    * Lista de clientes de la tienda
    */
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    /**
    * Constructor del servidor
    */
    public Servidor(){
        enLinea = true;
        listaClientes.add(new Cliente("Gaelinho", "12345", "Gael Garcia", "5519032326", "N1 101", "GAG0210", "Mexico", 1));
        listaClientes.add(new Cliente("X", "321", "Unknown", "5519032327", "N1 40", "XRX", "EUA", 2));
    }

    /**
    * Crea y devuelve una lista de los clientes como ClienteProxy
    *
    * @return Lista de clientes como ClienteProxy
    */
    public ArrayList<ClienteProxy> crearClientesProxy(){
        ArrayList<ClienteProxy> clientesProxy = new ArrayList<ClienteProxy>();
        for (Cliente c : listaClientes) {
            clientesProxy.add(new ClienteProxy(c));
        }
        return clientesProxy;
    }

    /**
    * Cierra el servidor de la tienda
    */
    public void cerrarServidor(){
        enLinea = false;
    }

    /**
    * Indica si el servidor esta en linea
    *
    * @return   true    -   si el servidor esta en linea
    *           false   -   si el servidor no esta en linea
    */
    public boolean enLinea(){
        return enLinea;
    }

}
