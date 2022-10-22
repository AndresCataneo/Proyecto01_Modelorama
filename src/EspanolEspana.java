import java.util.ArrayList;
/**
 * Clase que simula una tienda de España.
 * 
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class EspanolEspana implements Idioma{

    /**
     * Saludo de bienvenida en el idioma español de España
     */
    @Override
    public void saludar(){
        System.out.println("Bienvenido a CheemsMart chaval!");
    }

    /**
     * Despliega el menu en español de España
     */
    @Override
    public void menuInicial(){
        System.out.println("Tenemos muchos productos para ti!");
    }

    /**
     * Despliega el menu de compra en español de España
     */
    @Override
    public void menuCompra(){
        System.out.println("Que le gustaría comprar chaval?");
    }

    /**
     * Despliega el ticket de compra en español de España
     */
    @Override
    public void ticketCompra(ArrayList<Producto> listaProductos){
        System.out.println("Su ticket es:");
        for(Producto producto : listaProductos){
            System.out.println(producto.informacion());
        }
    }

    /**
     * Despliega la fecha de entrega de los productos en español de España
     */
    @Override
    public void fechaEntrega(){
        System.out.println("Sus productos serán entregados en 3 dias");
    }

    /**
     * Despedida en español de España
     */
    @Override
    public void despedirse(){
        System.out.println("Gracias por su compra!");
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
            System.out.println("El producto cuesta " + precio);
        }else{
            System.out.println("Lo sentimos, no hay productos en el inventario");
        }
    }
          
    
}
