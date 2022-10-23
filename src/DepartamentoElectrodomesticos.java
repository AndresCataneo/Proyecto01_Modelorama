/**
 * Clase que simula un departamento de productos de electrodomesticos.
 *
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class DepartamentoElectrodomesticos extends Departamento{

    /**
     * Constructor de un departamento de electrodomesticos
     */
    public DepartamentoElectrodomesticos() {
        super("Electrodomésticos");
        agregarProducto();
    }

    /**
     * Agrega algunos productos base al departamento
     */
    public void agregarProducto(){
        Producto producto1 = new Producto("Lavadora", 10000, 2001);
        Producto producto2 = new Producto("Refrigerador", 5000, 2002);
        Producto producto3 = new Producto("Estufa", 3000, 2003);
        Producto producto4 = new Producto("Licuadora", 2000, 2004);
        Producto producto5 = new Producto("Horno", 1000, 2005);
        Producto producto6 = new Producto("Microondas", 500, 2006);

        this.agregarProducto(producto1);
        this.agregarProducto(producto2);
        this.agregarProducto(producto3);
        this.agregarProducto(producto4);
        this.agregarProducto(producto5);
        this.agregarProducto(producto6);
    }

}
