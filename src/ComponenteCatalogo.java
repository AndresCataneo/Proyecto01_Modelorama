
import java.util.Iterator;
import java.lang.UnsupportedOperationException;

/**
* Clase que simula un componente de un catalogo, ya sea un producto
* o un departamento.
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public abstract class ComponenteCatalogo {

    /**
    * Regresa la información del componente
    *
    * @return Cadena con la información del componente
    */
    public String informacion(){
        throw new UnsupportedOperationException();
    }

    /**
    * Agrega un producto al componente
    *
    * @param producto Producto a agregar
    */
    public void agregarProducto(Producto producto){
        throw new UnsupportedOperationException();
    }

    /**
    * Crea un iterador de la lista de componentes del componente
    *
    * @return Iterador de los componentes
    */
    public Iterator getIterador(){
        throw new UnsupportedOperationException();
    }

}
