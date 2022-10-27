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
     * Saludo de bienvenida en el idioma español mexicano
     */
    @Override
    public void saludar(){
        System.out.println("¡Bienvenido a CheemsMart carnal!");
    }

    /**
     * Despliega el menu en español mexicano
     */
    @Override
    public void menuInicial(){
        System.out.println("¡Tenemos muchos productos para ti!\n" +
                            "1. Wachar el catalogo\n" +
                            "2. Comprar algo\n" +
                            "3. Cerrar sesion\n" +
                            "0. Salir de la tienda");
    }

    /**
     * Despliega el menu de compra en español mexicano
     */
    @Override
    public void menuCompra(){
        System.out.println("1. Agregar al carrito\n" +
                            "2. Dar la lana ya\n" +
                            "0. Cancelar compra");
    }

    /**
    * Agrega un producto al carrito del cliente a partir de su codigo de barras en español mexicano
    *
    * @parma sesion Cliente que agregara algo a su carrito
    */
    @Override
    public void agregarAlCarrito(ClienteProxy sesion){
        if (sesion.getCarrito() != null) {
            System.out.println("Carnalito... UN PRODUCTO A LA VEZ. Ya hay un producto en el carrito.");
            return ;
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingresa el código de barras del producto");
        int codigoBarras;
        while (true) {
            try {
                String opcionUsuario = scn.nextLine();
                codigoBarras = Integer.parseInt(opcionUsuario);
                break;
            } catch(NumberFormatException e) {
                opcionInvalida();
                System.out.println("Ingresa un código de barras de producto");
            }
        }
        Catalogo catalogo = Catalogo.getInstance();
        Producto aComprar = catalogo.getProducto(codigoBarras);
        if (aComprar == null) {
            System.out.println("Producto no encontrado");
            return ;
        }
        sesion.agregarAlCarrito(aComprar);
    }

    /**
    * Pantalla de compra segura en español mexicano
    *
    * @param sesion Cliente que busca pagar
    */
    @Override
    public void compraSegura(ClienteProxy sesion){
        Scanner scn = new Scanner(System.in);
        System.out.println("*****COMPRA SEGURA*****");
        System.out.println("Para su seguridad necesitamos que ingrese " +
                            "su número de cuenta bancaria");
        System.out.println("Solo tienes una chance");
        String numCuentaBanco = scn.nextLine();
        if (!sesion.compraSegura(numCuentaBanco)) {
            System.out.println("Eso es todo. No te apures, la " +
            "migra ya esta en camino");
            System.exit(1);
        }
        System.out.println("Transacción exitosa");
    }

    /**
     * Despliega la fecha de entrega de los productos en español mexicano
     */
    @Override
    public void fechaEntrega(){
        System.out.println("\nSus productos serán entregados en 3 días\n");
    }

    /**
     * Despedida en español mexicano
     */
    @Override
    public void despedirse(){
        System.out.println("¡Hasta luego carnal!");
    }

    /**
    * Mensaje de error en español mexicano al seleccionar una opcion
    */
    @Override
    public void opcionInvalida(){
        System.out.println("Opción inválida carnal");
    }

    /**
     * Metodo que enviará un mensaje al cliente en español mexicano para que entienda por que no se puede realizar la accion
     * @param opcion
     */
    @Override
    public void mensajeAlerta(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("Carnal. No puedes comprar más de un producto a la vez");
                break;
            case 2:
            System.out.println("Padrino, no has agregado nada a tu carrito, seriedad por favor");
                break;
            case 3:
                System.out.println("Carnal. No puedes cancelar la compra si no tienes un producto en el carrito");
                break;
            case 4:
                System.out.println("Carnal. No puedes comprar el procucto porque no tienes suficiente saldo");
                break;
            default:
                break;
        }

    }

    /**
     * Metodo para que el cliente vea su saldo de su cuenta en español mexicano
     * @param sesion
     */
    @Override
    public String verSaldo(ClienteProxy sesion){
        return "Padrino, su saldo es de: " + sesion.getSaldo();
    }

}
