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
        System.out.println("¡Tenemos muchos productos para ti!");
    }

    /**
     * Despliega el menu de compra en español de México
     */
    @Override
    public void menuCompra(){
        System.out.println("¿Qué quieres comprar carnal?");
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
    
}
