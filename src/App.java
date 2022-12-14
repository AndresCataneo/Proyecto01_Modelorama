
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que simula la interacción del usuario en una tienda
 *
 * @author Pedro
 * @author Gaelinho
 * @author Andres
 * @version octubre 2022
 */
public class App {

    /**
     * Método principal de la clase App
     */
    public static void main(String[] args){
        Tienda t = new Tienda();

        Scanner scn = new Scanner(System.in);
        int menuInicial;
        do {
            //--------------------Inicio de sesión--------------------
            while(!t.haySesionIniciada()){
                System.out.print("Usuario: ");
                String usuario = scn.nextLine();
                System.out.print("Contraseña: ");
                String contrasena = scn.nextLine();
                t.iniciarSesion(usuario, contrasena);
                if (!t.haySesionIniciada()) {
                    System.out.println("Usuario y/o contraseña invalidos");
                }
            }
            //--------------------Menú principal--------------------
            t.saludar();
            do {
                t.menuInicial();
                while (true) {
                    try {
                        String opcionUsuario = scn.nextLine();
                        menuInicial = Integer.parseInt(opcionUsuario);
                        break;
                    } catch(NumberFormatException e) {
                        t.opcionInvalida();
                        t.menuInicial();
                    }
                }
                switch (menuInicial) {
                    case 1:
                        t.catalogo();
                        break;
                    case 2:
                        int menuCompra;
                        t.catalogo();
                        do {
                            t.menuCompra();
                            while (true) {
                                try {
                                    String opcionUsuario = scn.nextLine();
                                    menuCompra = Integer.parseInt(opcionUsuario);
                                    break;
                                } catch(NumberFormatException e) {
                                    t.opcionInvalida();
                                    t.menuCompra();
                                }
                            }
                            //--------------------Sección para comprar un producto--------------------
                            switch (menuCompra) {
                                case 1:
                                    t.catalogo();
                                    t.agregarAlCarrito();
                                    break;
                                case 2:
                                    t.pagar();
                                    menuCompra = 0;
                                    break;
                                case 0:
                                    t.borrarCarrito();
                                    break;
                                default:
                                    t.opcionInvalida();
                                    break;
                            }
                        } while (menuCompra != 0);
                        break;
                    case 3:
                        t.cerrarSesion();
                        break;
                    case 0:
                        t.cerrarSesion();
                        t.despedirse();
                        break;
                    default:
                        t.opcionInvalida();
                        break;
                }
            } while (menuInicial != 0 && menuInicial != 3);
        } while (menuInicial != 0);

    }
}
