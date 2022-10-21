/**
 * Clase que simula un departamento de productos alimenticios
 * 
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class DepartamentoAlimenticios extends Departamento{

    /**
     * Constructor de un departamento de alimenticios
     * 
     * @param nombre Nombre del departamento
     */
    public DepartamentoAlimenticios(String nombre) {
        super(nombre);
    }

    /**
     * Agrega algunos productos base al departamento
     */
    public void agregarProducto(){
        Producto producto1 = new Producto("Leche", 10);
        Producto producto2 = new Producto("Huevos", 20);
        Producto producto3 = new Producto("Pan", 30);
        Producto producto4 = new Producto("Queso", 40);
        Producto producto5 = new Producto("Jamon", 50);
        Producto producto6 = new Producto("Cereal", 60);

        this.agregarProducto(producto1);
        this.agregarProducto(producto2);
        this.agregarProducto(producto3);
        this.agregarProducto(producto4);
        this.agregarProducto(producto5);
        this.agregarProducto(producto6);  
    }
    
}
