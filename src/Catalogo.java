
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
    * Lista de los departamentos del catalogo.
    */
    private static ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();

    /**
    * Unico catalogo
    */
    private static Catalogo unicoCatalogo;

    /**
    * Constructor del catalogo
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
    * Devuelve la misma instancia del catalogo
    *
    * @return Unico catalogo
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
    * @return Cadena con la información del catálogo
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
    * Agrega un departamento al catalogo
    *
    * @param departamento Departamento a agregar
    */
    private static void agregarDepartamento(Departamento departamento){
        listaDepartamentos.add(departamento);
    }

    /**
    * Crea un iterador de la lista de departamentos del catalogo
    *
    * @return Iterador de los departamentos
    */
    public Iterator getIterador(){
        return listaDepartamentos.iterator();
    }

    /**
    * Busca y devuelve un producto en el catalogo a partir
    * de su codigo de barras, en caso de no existir el código
    * en el catalogo, regresa null
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
