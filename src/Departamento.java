
import java.util.ArrayList;
import java.util.Iterator;

/**
* Clase que simula un departamento del catálogo.
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public class Departamento extends ComponenteCatalogo {

    /**
    * Nombre del departamento
    */
    private String nombre;

    /**
    * Lista de productos del departamento
    */
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    /**
    * Constructor de un departamento
    *
    * @param nombre Nombre del departamento
    */
    public Departamento(String nombre){
        this.nombre = nombre;
    }

    /**
    * Regresa el nombre del departamento
    *
    * @return nombre - Cadena que representa el nombre del departamento
    */
    public String getNombre(){
        return nombre;
    }

    /**
     * Método que agrega un producto al departamento
     * 
     * @param producto Producto a agregar
     */
    @Override
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
        producto.setDepartamento(this);
    }

    /**
     * Método que crea un iterador de la lista de productos del departamento
     * 
     * @return informacion - Cadena con la información del producto
     */
    @Override
    public String informacion(){
        Iterator iterador = getIterador();
        String informacion = "*****" + getNombre() + "*****\n";
        while (iterador.hasNext()) {
            Producto p = (Producto) iterador.next();
            informacion += p.informacion() + "\n";
        }
        return informacion;
    }

    /**
     * Método que crea un iterador de la lista de productos del departamento
     * 
     * @return iterator - Iterador de la lista de productos del departamento
     */
    @Override
    public Iterator getIterador(){
        return listaProductos.iterator();
    }

}
