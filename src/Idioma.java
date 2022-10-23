import java.util.ArrayList;
/*
 * Interfaz para el manejo de idiomas de las tiendas de cierta país
 *
 *
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public interface Idioma {


    /**
     * Saludo de bienvenida en el idioma del país
     */
    public void saludar();

    /**
     * Despliega el menu
     */
    public void menuInicial();

    /**
     * Despliega el menu de compra
     */
    public void menuCompra();

    /**
     * Despliega la fecha de entrega de los productos
     */
    public void fechaEntrega();

    /**
     * Despedida en el idioma del país
     */
    public void despedirse();

    /**
    * Mensaje de error al seleccionar una opcion
    */
    public void opcionInvalida();

}