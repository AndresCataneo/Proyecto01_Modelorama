import java.util.ArrayList;
/**
 * Clase que simula una tienda de México
 *
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class EspanolMexico implements Idioma{

    /**
     * Saludo de bienvenida en el idioma español de México
     */
    @Override
    public void saludar(){
        System.out.println("¡Bienvenido a CheemsMart carnal!");
    }

    /**
     * Despliega el menu en español de México
     */
    @Override
    public void menuInicial(){
        System.out.println("¡Tenemos muchos productos para ti!\n" +
                            "1. Ver el catalogo\n" +
                            "2. Comprar algo\n" +
                            "0. Salir de la tienda");
    }

    /**
     * Despliega el menu de compra en español de México
     */
    @Override
    public void menuCompra(){
        System.out.println("1. Agregar al carrito\n" +
                            "2. Pagar ya\n" +
                            "0. Cancelar compra");
    }

    /**
     * Despliega el ticket de compra en español de México
     *
     */
    @Override
    public void ticketCompra(ArrayList<Producto> listaProductos){
        System.out.println("Su ticket es:");
        for(Producto producto : listaProductos){
            System.out.println(producto.informacion());
        }
    }

    /**
     * Despliega la fecha de entrega de los productos en español de México
     */
    @Override
    public void fechaEntrega(){
        System.out.println("Sus productos serán entregados en 3 días");
    }

    /**
     * Despedida en español de México
     */
    @Override
    public void despedirse(){
        System.out.println("¡Hasta luego!");
    }

    /**
     * Despliega el mensaje sobre si hay productos en el inventario
     *
     * @param hayProducto Booleano que indica si hay productos en el inventario
     * @param precio - Precio del producto
     */
    @Override
    public void hayProducto(boolean hayProducto, double precio){
        if(hayProducto){
            System.out.println("El precio es de $" + precio);
        }else{
            System.out.println("Lo siento, no ha seleccionado algun producto");
        }
    }

}
