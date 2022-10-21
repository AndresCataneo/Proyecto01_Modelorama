

/**
* Clase que simula un producto del catálogo.
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public class Producto extends ComponenteCatalogo {

    /**
    * Codigo de barras del producto
    */
    private int codigoBarras;

    /**
    * Nombre del producto
    */
    private String nombre;

    /**
    * Precio del producto
    */
    private double precio;

    /**
    * Departamento al que pertenece el producto
    */
    private Departamento departamento;

    /**
    * Constructor de un producto
    *
    * @param nombre Nombre del producto
    * @param precio Precio del producto
    */
    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
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

    /**
    * Regresa el precio del producto
    *
    * @return Double que representa el precio del producto
    */
    public double getPrecio(){
        return precio;
    }

    /**
    * Regresa el nombre del departamento del producto
    *
    * @return Nombre del departamento del producto
    */
    public String getNombreDepartamento(){
        return departamento.getNombre();
    }

    /**
    * Establece el descuento del producto
    *
    * @param codigoBarras Entero que representa el nuevo descuento
    */
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }

    @Override
    public String informacion(){
        return getCodigoBarras() + " - " + getNombre() + " $" + getPrecio();
    }

}
