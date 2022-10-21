/**
 * Clase que simula un departamento de productos de electronica.
 * 
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class DepartamentoElectronica extends Departamento{

    /**
     * Constructor de un departamento de electronica
     * 
     * @param nombre Nombre del departamento
     */
    public DepartamentoElectronica(String nombre) {
        super(nombre);
    }

    /**
     * Agrega algunos productos base al departamento
     */
    public void agregarProducto(){
        Producto producto1 = new Producto("Laptop", 10000);
        Producto producto2 = new Producto("Television", 5000);
        Producto producto3 = new Producto("Celular", 3000);
        Producto producto4 = new Producto("Tablet", 2000);
        Producto producto5 = new Producto("Audifonos", 1000);
        Producto producto6 = new Producto("Cargador", 500);

        this.agregarProducto(producto1);
        this.agregarProducto(producto2);
        this.agregarProducto(producto3);
        this.agregarProducto(producto4);
        this.agregarProducto(producto5);
        this.agregarProducto(producto6);  
    }
    
}
