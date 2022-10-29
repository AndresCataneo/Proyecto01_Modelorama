/**
* Interfaz para controlar la informacion que veran los espectadores
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public interface Sujeto {

    /**
     * Metodo para agregar espectadores a la lista correspondiente
     *
     * @param cliente - Espectador que se agregará a la lista
     */
    public void registrarObservador(Cliente cliente);

    /**
     * Metodo para quitar espectadores de la lista correspondiente
     *
     * @param cliente - Espectador que se quitará de la lista
     */
    public void quitarObservador(Cliente cliente);

    /**
     * Metodo para notificar a los espectadores cuando haya un cambio
     */
    public void notificarObservador();
}
