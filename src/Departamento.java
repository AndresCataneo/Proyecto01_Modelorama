
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
    * @return Cadena que representa el nombre del departamento
    */
    public String getNombre(){
        return nombre;
    }

    @Override
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
        producto.setDepartamento(this);
    }

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

    @Override
    public Iterator getIterador(){
        return listaProductos.iterator();
    }

}
