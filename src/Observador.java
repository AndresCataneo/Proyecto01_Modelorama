/**
* Interfaz que actualizará la información que veran los clientes
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public interface Observador {
    
    /**
     * Actualiza la información que veran los clientes
     * 
     * @param mensaje Mensaje que se le enviara al cliente
     */ 
    public void actualizar(String mensaje);
}
