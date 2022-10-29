
import java.util.ArrayList;
import java.util.Iterator;

/**
* Clase que simula un catálogo de CheemsMart.
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public class Catalogo {

    /**
    * Lista de los departamentos del catálogo.
    */
    private static ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();

    /**
    * Único catálogo
    */
    private static Catalogo unicoCatalogo;

    /**
    * Constructor del catálogo
    */
    private Catalogo(){
        Departamento alimenticios = new DepartamentoAlimenticios();
        Departamento electrodomesticos = new DepartamentoElectrodomesticos();
        Departamento electronica = new DepartamentoElectronica();
        agregarDepartamento(alimenticios);
        agregarDepartamento(electrodomesticos);
        agregarDepartamento(electronica);
    }

    /**
    * Devuelve la misma instancia del catálogo
    *
    * @return Único catálogo - Devulve la única instancia del catálogo
    */
    public static Catalogo getInstance(){
        if (unicoCatalogo == null) {
            unicoCatalogo = new Catalogo();
        }
        return unicoCatalogo;
    }

    /**
    * Regresa la información del catálogo
    *
    * @return informacion- Información con la información del catálogo
    */
    public String informacion(){
        Iterator iterador = getIterador();
        String informacion = "*****CATALOGO*****\n\n";
        while (iterador.hasNext()) {
            Departamento d = (Departamento) iterador.next();
            informacion += d.informacion() + "\n";
        }
        return informacion;
    }

    /**
    * Agrega un departamento al catálogo
    *
    * @param departamento - Departamento a agregar
    */
    private static void agregarDepartamento(Departamento departamento){
        listaDepartamentos.add(departamento);
    }

    /**
    * Crea un iterador de la lista de departamentos del catálogo
    *
    * @return Iterator - Iterador de los departamentos
    */
    public Iterator getIterador(){
        return listaDepartamentos.iterator();
    }

    /**
    * Busca y devuelve un producto en el catálogo a partir
    * de su codigo de barras, en caso de no existir el código
    * en el catálogo, regresa null
    *
    * @param codigoBarras Código de barras del producto deseado
    *
    * @return Producto deseado o null en caso de no existir
    */
    public Producto getProducto(int codigoBarras){
        Iterator iteradorDepartamentos = getIterador();
        while (iteradorDepartamentos.hasNext()) {
            Departamento d = (Departamento) iteradorDepartamentos.next();
            Iterator iteradorProductos = d.getIterador();
            while (iteradorProductos.hasNext()) {
                Producto p = (Producto) iteradorProductos.next();
                if (codigoBarras == p.getCodigoBarras()) {
                    return p;
                }
            }
        }
        return null;
    }

}
