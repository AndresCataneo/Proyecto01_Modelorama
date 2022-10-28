

/**
* Interfaz de cliente.
*
* @author Pedro
* @author Gaelinho
* @author Andres
* @version octubre 2022
*
*/
public interface InterfazCliente {

    /**
    * Indica si los datos de la cuenta bancaria son correctos
    *
    * @param cuentaBanco Cuenta bancaria a revisar
    *
    * @return   true    -   si los datos son correctos
    *           false   -   si no son correctos
    */
    public boolean compraSegura(String cuentaBanco);

}
