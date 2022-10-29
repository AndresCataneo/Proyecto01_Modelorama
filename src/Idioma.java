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
     * Despliega el menú
     */
    public void menuInicial();

    /**
     * Despliega el menú de compra
     */
    public void menuCompra();

    /**
    * Agrega un producto al carrito del cliente a partir de su codigo de barras
    *
    * @parma sesion Cliente que agregará algo a su carrito
    */
    public void agregarAlCarrito(ClienteProxy sesion);

    /**
    * Pantalla de compra segura
    *
    * @param sesion Cliente que busca pagar
    */
    public void compraSegura(ClienteProxy sesion);

    /**
     * Despliega la fecha de entrega de los productos
     */
    public void fechaEntrega();

    /**
     * Despedida en el idioma del país
     */
    public void despedirse();

    /**
    * Mensaje de error al seleccionar una opción
    */
    public void opcionInvalida();

    /**
     * Método que enviará un mensaje al cliente para que entienda por que no se puede realizar la acción
     * 
     * @param opcion Opción que no se puede realizar o un mensaje que se quiere enviar al cliente
     */
    public void mensajeAlerta(int opcion);

    /**
     * Método para que el cliente vea su saldo de su cuenta
     * 
     * @param sesion
     */
    public String verSaldo(ClienteProxy sesion);

}
