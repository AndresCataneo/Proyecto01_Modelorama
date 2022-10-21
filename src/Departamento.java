
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
    * Codigo de barras del departamento
    */
    private int codigoBarras;

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
    * Regresa el codigo de barras del producto
    *
    * @return Entero que representa el codigo de barras del producto
    */
    public int getCodigoBarras(){
        return codigoBarras;
    }

    /**
    * Establece el codigo de barras del producto
    *
    * @param codigoBarras Entero que representa el nuevo codigo de barras
    */
    public void setCodigoBarras(int codigoBarras){
        this.codigoBarras = codigoBarras;
    }

    /**
    * Regresa el nombre del producto
    *
    * @return Cadena que representa el nombre del producto
    */
    public String getNombre(){
        return nombre;
    }

    @Override
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
        producto.setDepartamento(this);
        producto.setCodigoBarras(getCodigoBarras() + listaProductos.size());
    }

    @Override
    public String informacion(){
        Iterator iterador = getIterador();
        String informacion = "*****" + getNombre() + "*****";
        informacion += "\n";
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
