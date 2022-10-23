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
     */
    public DepartamentoAlimenticios() {
        super("Alimenticios");
        agregarProducto();
    }

    /**
     * Agrega algunos productos base al departamento
     */
    public void agregarProducto(){
        Producto producto1 = new Producto("Leche", 10, 1001);
        Producto producto2 = new Producto("Huevos", 20, 1002);
        Producto producto3 = new Producto("Pan", 30, 1003);
        Producto producto4 = new Producto("Queso", 40, 1004);
        Producto producto5 = new Producto("Jamon", 50, 1005);
        Producto producto6 = new Producto("Cereal", 60, 1006);

        this.agregarProducto(producto1);
        this.agregarProducto(producto2);
        this.agregarProducto(producto3);
        this.agregarProducto(producto4);
        this.agregarProducto(producto5);
        this.agregarProducto(producto6);
    }

}
