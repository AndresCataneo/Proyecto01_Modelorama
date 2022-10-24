import java.util.Scanner;
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

    @Override
    public void agregarAlCarrito(ClienteProxy sesion){
        if (sesion.getCarrito() != null) {
            System.out.println("ONE BY ONE. There is a product already in your cart.");
            return ;
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Write de product barcode:");
        int codigoBarras = scn.nextInt();
        Catalogo catalogo = Catalogo.getInstance();
        Producto aComprar = catalogo.getProducto(codigoBarras);
        if (aComprar == null) {
            System.out.println("Product not found");
            return ;
        }
        sesion.agregarAlCarrito(aComprar);
    }

    @Override
    public void compraSegura(ClienteProxy sesion){
        Scanner scn = new Scanner(System.in);
        System.out.println("*****SAFETY PURCHASR*****");
        System.out.println("For your safety, we need you to write " +
                            "your bank account number");
        System.out.println("You have only one try");
        String numCuentaBanco = scn.nextLine();
        if (!sesion.compraSegura(numCuentaBanco)) {
            System.out.println("That's all. " +
            "Police is coming");
            System.exit(1);
        }
        System.out.println("Purcharse successful");
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


    @Override
    public void mensajeAlerta(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("You can't add more than one product to your cart");
                break;
            case 2:
                System.out.println("Oh man, you are stupid bro, you ain't bought nothing");
                break;
            case 3:
                System.out.println("You can't cancel a purchase if you don't have a product in your cart");
                break;
            case 4:
                System.out.println("You can't pay the product because you don't have enough money");
                break;
            default:
                break;
        }
    }
}
