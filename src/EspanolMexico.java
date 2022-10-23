import java.util.Scanner;

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

    @Override
    public void agregarAlCarrito(ClienteProxy sesion){
        if (sesion.getCarrito() != null) {
            System.out.println("UN PRODUCTO A LA VEZ. Ya hay un producto en el carrito.");
            return ;
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingresa el código de barras del producto");
        int codigoBarras = scn.nextInt();
        Catalogo catalogo = Catalogo.getInstance();
        Producto aComprar = catalogo.getProducto(codigoBarras);
        if (aComprar == null) {
            System.out.println("Producto no encontrado");
            return ;
        }
        sesion.agregarAlCarrito(aComprar);
    }

    @Override
    public void compraSegura(ClienteProxy sesion){
        Scanner scn = new Scanner(System.in);
        System.out.println("*****COMPRA SEGURA*****");
        System.out.println("Para su seguridad necesitamos que ingrese " +
                            "su número de cuenta bancaria");
        System.out.println("Solo tienes una oportunidad");
        String numCuentaBanco = scn.nextLine();
        if (!sesion.compraSegura(numCuentaBanco)) {
            System.out.println("Eso es todo. No te apures, la " +
            "policía ya esta en camino");
            System.exit(1);
        }
        System.out.println("Transacción exitosa");
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

    @Override
    public void opcionInvalida(){
        System.out.println("Opción inválida carnal");
    }

}
