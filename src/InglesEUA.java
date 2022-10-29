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
     * Saludo de bienvenida en el idioma ingles estadounidense
     */
    @Override
    public void saludar(){
        System.out.println("Welcome to CheemsMart!");
    }

    /**
     * Despliega el menú en ingles estadounidense
     */
    @Override
    public void menuInicial(){
        System.out.println("We have a lot of products for you!\n" +
                            "1. See the catalog\n" +
                            "2. Buy something\n" +
                            "3. Sign off\n" +
                            "0. Exit store");
    }

    /**
     * Despliega el menú de compra en ingles estadounidense
     */
    @Override
    public void menuCompra(){
        System.out.println("1. Add to cart\n" +
                            "2. Pay now\n" +
                            "0. Cancel purchase");
    }

    /**
    * Agrega un producto al carrito del cliente a partir de su codigo de barras en ingles estadounidense
    *
    * @parma sesion Cliente que agregará algo a su carrito
    */
    @Override
    public void agregarAlCarrito(ClienteProxy sesion){
        if (sesion.getCarrito() != null) {
            System.out.println("ONE BY ONE. There is a product already in your cart.");
            return ;
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Write the product barcode:");
        int codigoBarras;
        while (true) {
            try {
                String opcionUsuario = scn.nextLine();
                codigoBarras = Integer.parseInt(opcionUsuario);
                break;
            } catch(NumberFormatException e) {
                opcionInvalida();
                System.out.println("Write a product barcode:");
            }
        }
        Catalogo catalogo = Catalogo.getInstance();
        Producto aComprar = catalogo.getProducto(codigoBarras);
        if (aComprar == null) {
            System.out.println("Product not found");
            return ;
        }
        sesion.agregarAlCarrito(aComprar);
    }

    /**
    * Pantalla de compra segura en ingles estadounidense
    * 
    * @param sesion Cliente que busca pagar
    */
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
     * Despliega la fecha de entrega de los productos en ingles estadounidense
     */
    @Override
    public void fechaEntrega(){
        System.out.println("\nYour product will be delivered in 3 days\n");
    }

    /**
     * Despedida en ingles estadounidense
     */
    @Override
    public void despedirse(){
        System.out.println("Thank you for your purchase!");
        System.out.println("See you soon!");
    }

    /**
    * Mensaje de error en ingles estadounidense al seleccionar una opción
    */
    @Override
    public void opcionInvalida(){
        System.out.println("Not a valid option");
    }

    /**
     * Método que enviará un mensaje al cliente en ingles para que entienda por que no se puede realizar la acción
     * 
     * @param opcion Opción que no se puede realizar o un mensaje que se quiere enviar al cliente
     */
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
                System.out.println("\nEh man, are you try play with me?, get of here, i will delete your cart\n");
                break;
            case 4:
                System.out.println("You can't pay the product because you don't have enough money");
                break;
            default:
                break;
        }
    }

    /**
     * Método para que el cliente vea su saldo de su cuenta en ingles
     * 
     * @param sesion Cliente que se le mostrará su saldo
     */
    @Override
    public String verSaldo(ClienteProxy sesion){
        return "Your balance is: " + sesion.getSaldo();
    }
}
