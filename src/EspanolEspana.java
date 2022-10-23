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
        System.out.println("¡Tenemos muchos productos para ti!\n" +
                            "1. Ver el catalogo\n" +
                            "2. Comprar algo\n" +
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

    @Override
    public void opcionInvalida(){
        System.out.println("Opción inválida chaval");
    }

}
