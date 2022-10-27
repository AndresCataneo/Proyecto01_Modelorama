import java.util.Scanner;
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
        System.out.println("¡Tenemos muchos productos para ti!\n" +
                            "1. Ver el catalogo\n" +
                            "2. Comprar algo\n" +
                            "3. Cerrar sesion\n" +
                            "0. Salir de la tienda");
    }

    /**
     * Despliega el menu de compra en español de España
     */
    @Override
    public void menuCompra(){
        System.out.println("1. Agregar al carrito\n" +
                            "2. Pagar ya\n" +
                            "0. Cancelar compra");
    }

    /**
    * Agrega un producto al carrito del cliente a partir de su codigo de barras en español de España
    *
    * @parma sesion Cliente que agregara algo a su carrito
    */
    @Override
    public void agregarAlCarrito(ClienteProxy sesion){
        if (sesion.getCarrito() != null) {
            System.out.println("Ostia tio. UN PRODUCTO A LA VEZ. Ya hay un producto en el carrito.");
            return ;
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Chaval, ingresa el código de barras del producto");
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
    * Pantalla de compra segura en español de España
    * 
    * @param sesion Cliente que busca pagar
    */
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
     * Despliega la fecha de entrega de los productos en español de España
     */
    @Override
    public void fechaEntrega(){
        System.out.println("\nSus productos serán entregados en 3 dias\n");
    }

    /**
     * Despedida en español de España
     */
    @Override
    public void despedirse(){
        System.out.println("Gracias por su compra!");
    }

    /**
    * Mensaje de error en español de españa al seleccionar una opcion
    */
    @Override
    public void opcionInvalida(){
        System.out.println("Opción inválida chaval");
    }

    /**
     * Metodo que enviará un mensaje al cliente en español de España para que entienda por que no se puede realizar la accion
     * @param opcion
     */
    @Override
    public void mensajeAlerta(int opcion){

        switch (opcion) {
            case 1:
                System.out.println("Chaval. No puedes comprar más de un producto a la vez");
                break;
            case 2:
            System.out.println("Pero por el Real madrid, y sus 14 copas, no has comprado nada aun, chaval te reviento");
                break;
            case 3:
                System.out.println("Ostiaaa tio, haber. No puedes cancelar la compra si no tienes un producto en el carrito");
                break;
            case 4:
                System.out.println("Chaval. No puedes comprar el procucto porque no tienes suficiente saldo");
                break;
            default:
                break;
        }
    }

    /**
     * Metodo para que el cliente vea su saldo de su cuenta en español de España
     * @param sesion
     */
    @Override
    public String verSaldo(ClienteProxy sesion){
        return "Chaval, su saldo es de: " + sesion.getSaldo();
    }

}
