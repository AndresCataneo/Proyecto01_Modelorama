/**
* Interfaz para controlar la información que veran los espectadores
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public interface Sujeto {

    /**
     * Método para agregar espectadores a la lista correspondiente
     *
     * @param cliente - Espectador que se agregará a la lista
     */
    public void registrarObservador(Cliente cliente);

    /**
     * Método para quitar espectadores de la lista correspondiente
     *
     * @param cliente - Espectador que se quitará de la lista
     */
    public void quitarObservador(Cliente cliente);

    /**
     * Método para notificar a los espectadores cuando haya un cambio
     */
    public void notificarObservador();
}
