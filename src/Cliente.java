
import java.io.Serializable;

/**
 * Clase que simula un cliente de CheemsMart.
 *
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 *
 */
public class Cliente implements InterfazCliente, Observador {

    /**
    * Nombre de usuario del cliente
    */
    private String nombreUsuario;

    /**
    * Contraseña del cliente
    */
    private String contrasena;

    /**
    * Nombre real del cliente
    */
    private String nombre;

    /**
    * Teléfono del cliente
    */
    private String telefono;

    /**
    * Dirección del cliente
    */
    private String direccion;

    /**
    * Cuenta bancaria del cliente
    */
    private String cuentaBanco;

    /**
    * País de origen del cliente
    */
    private String pais;

    /**
     * Saldo de la cuenta del cliente
     */
    private double saldo;

    /**
    * ID del cliente
    */
    private long id;

    /**
    * Cadena con la promocion que puede aprovechar el cliente
    */
    private String promocion;

    /**
    * Constructor de un cliente
    *
    * @param nombreUsuario Nombre de usuario del cliente
    * @param contrasena Contraseña del cliente
    * @param nombre Nombre real del cliente
    * @param telefono Teléfonodel cliente
    * @param direccion Domicilio del cliente
    * @param cuentaBanco Cuenta Bancaria del cliente
    * @param pais Pais de origen del cliente
    * @param saldo Saldo del usuario
    * @param id ID del cliente
    */
    public Cliente(String nombreUsuario, String contrasena, String nombre,
                    String telefono, String direccion, String cuentaBanco,
                    String pais,double saldo, long id){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBanco = cuentaBanco;
        this.pais = pais;
        this.saldo = saldo;
        this.id = id;
    }

    /**
     * Metodo para que el cliente inicie sesion y pueda ver y comprar productos de la tienda
     *
     * @param nombreUsuario Nombre de usuario del cliente
     * @param contrasena Contraseña del cliente
     * @return boolean si el inicio de sesion fue exitoso, false si no lo fue
     */
    public boolean inicioSesion(String nombreUsuario, String contrasena){
        return nombreUsuario.equals(this.nombreUsuario)
            && contrasena.equals(this.contrasena);
    }

    /**
     * Metodo para verificar los datos de la cuenta bancaria del cliente y pueda comprar productos
     *
     * @param cuentaBanco Cuenta bancaria del cliente
     * @return boolean si la compra fue exitosa, false si no lo fue
     */
    public boolean compraSegura(String cuentaBanco){
        return cuentaBanco.equals(this.cuentaBanco);
    }

    /**
     * Metodo para obtener el nombre de usuario del cliente
     *
     * @return nombre - Nombre de usuario del cliente
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo para obtener el telefono del cliente
     *
     * @return telefono - Telefono del cliente
     */
    public String getTelefono(){
        return telefono;
    }

    /**
     * Metodo para obtener la direccion del cliente
     *
     * @return direccion - Direccion del cliente
     */
    public String getDireccion(){
        return direccion;
    }

    /**
     * Metodo para obtener el pais de origen del cliente
     *
     * @return pais - Pais de origen del cliente
     */
    public String getPais(){
        return pais;
    }

    /**
     * Metodo para obtener el ID del cliente
     *
     * @return id - ID del cliente
     */
    public long getID(){
        return id;
    }

    /**
     * Metodo para obtener el saldo del cliente
     *
     * @return saldo - Saldo del cliente
     */
    public double getSaldo(){
        return saldo;
    }

    /**
     * Metodo para cambiar el saldo del cliente
     *
     * @return saldo - Saldo del cliente
     */
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    /**
    * Devuelve la promocion que aplica para el cliente
    *
    * @return Cadena con la promocion dirigida al cliente
    */
    public String getPromocion(){
        return promocion;
    }

    /**
    *
    */
    public void actualizar(String mensaje){
        actualizarPromocion(mensaje);
    }

    /**
    *
    */
    public void actualizarPromocion(String mensaje){
        promocion = mensaje;
    }
}
