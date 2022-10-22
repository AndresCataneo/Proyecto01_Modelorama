import java.util.ArrayList;
/**
 * Clase que simula una tienda de los Estados Unidos.
 * 
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class InglesEUA implements Idioma{

    /**
     * Saludo de bienvenida en el idioma ingles de los Estados Unidos
     */
    @Override
    public void saludar(){
        System.out.println("Welcome to CheemsMart!");
    }

    /**
     * Despliega el menu en ingles de los Estados Unidos
     */
    @Override
    public void menuInicial(){
        System.out.println("We have a lot of products for you!");
    }

    /**
     * Despliega el menu de compra en ingles de los Estados Unidos
     */
    @Override
    public void menuCompra(){
        System.out.println("What do you want to buy?");
    }

    /**
     * Despliega el ticket de compra en ingles de los Estados Unidos
     * 
     */
    @Override
    public void ticketCompra(ArrayList<Producto> listaProductos){
        System.out.println("Your ticket is:");
        for(Producto producto : listaProductos){
            System.out.println(producto.informacion());
        }
    }

    /**
     * Despliega la fecha de entrega de los productos en ingles de los Estados Unidos
     */
    @Override
    public void fechaEntrega(){
        System.out.println("Your products will be delivered in 3 days");
    }

    /**
     * Despedida en ingles de los Estados Unidos
     */
    @Override
    public void despedirse(){
        System.out.println("Thank you for your purchase!");
        System.out.println("See you soon!");
    }

    /**
     * Despliega el mensaje sobre si hay un producto en ingles de los Estados Unidos
     * 
     * @param hayProducto Booleano que indica si hay productos en el inventario
     * @param precio - Precio del producto
     */
    @Override
    public void hayProducto(boolean hayProducto, double precio) {
        if(hayProducto){
            System.out.println("The price is: " + precio);
        }else{
            System.out.println("You havn't selected any product");
        }
    }
    
}
