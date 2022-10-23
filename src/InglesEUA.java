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
        System.out.println("We have a lot of products for you!\n" +
                            "1. See the catalog\n" +
                            "2. Buy something\n" +
                            "0. Exit store");
    }

    /**
     * Despliega el menu de compra en ingles de los Estados Unidos
     */
    @Override
    public void menuCompra(){
        System.out.println("1. Add to cart\n" +
                            "2. Pay now\n" +
                            "0. Cancel purchase");
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

    @Override
    public void opcionInvalida(){
        System.out.println("Not a valid option");
    }

}
