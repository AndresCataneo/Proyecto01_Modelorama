
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
public class Cliente implements Serializable, InterfazCliente {

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
    * ID del cliente
    */
    private long id;

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
    * @param id ID del cliente
    */
    public Cliente(String nombreUsuario, String contrasena, String nombre,
                    String telefono, String direccion, String cuentaBanco,
                    String pais, long id){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBanco = cuentaBanco;
        this.pais = pais;
        this.id = id;
    }

    public boolean inicioSesion(String nombreUsuario, String contrasena){
        return nombreUsuario.equals(this.nombreUsuario)
            && contrasena.equals(this.contrasena);
    }

    public boolean compraSegura(String cuentaBanco){
        return cuentaBanco.equals(this.cuentaBanco);
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getPais(){
        return pais;
    }

    public long getID(){
        return id;
    }

}
