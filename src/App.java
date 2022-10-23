
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        if ("servidor".equals(args[0])) {
            startServidor();
        } else if("tienda".equals(args[0])){
            startTienda();
        }
    }

    public static void startServidor(){
        try {
            System.out.println("Iniciando servidor");
            Servidor servidorTienda = new Servidor();
            ServerSocket server = new ServerSocket(8080);
            while (servidorTienda.enLinea()) {
                Socket s = server.accept();
                RemoteMessagePassing rmp = new RemoteMessagePassing(s);
                String opcion = (String) rmp.receive();
                if (opcion.equals("descargarClientes")) {
                    System.out.println("Enviando lista de clientes");
                    rmp.send(servidorTienda.crearClientesProxy());
                } else if (opcion.equals("cerrarServidor")) {
                    System.out.println("Cerrando servidor");
                    servidorTienda.cerrarServidor();
                } else {
                    System.out.println("Accion no valida");
                }
                rmp.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void startTienda(){
        Tienda t = new Tienda();

        Scanner scn = new Scanner(System.in);
        while(!t.haySesionIniciada()){
            System.out.println("Usuario: ");
            String usuario = scn.nextLine();
            System.out.println("Contraseña: ");
            String contrasena = scn.nextLine();
            t.iniciarSesion(usuario, contrasena);
        }
        t.saludar();
        int menuInicial;
        do { // En los menus falta colocar los try catch para que no falle jeje
            t.menuInicial();
            menuInicial = scn.nextInt();
            switch (menuInicial) {
                case 1:
                    t.catalogo();
                break;
                case 2:
                    int menuCompra;
                    do {
                        t.catalogo();
                        t.menuCompra();
                        menuCompra = scn.nextInt();
                        switch (menuCompra) {
                            case 1:
                                t.agregarAlCarrito();
                                break;
                            case 2:
                                t.pagar();
                                menuCompra = 0;
                                break;
                            case 0:
                                break;
                            default:
                                t.opcionInvalida();
                                break;
                        }
                    } while (menuCompra != 0);
                    break;
                case 0:
                    break;
                default:
                    t.opcionInvalida();
                    break;
            }
        } while (menuInicial != 0);
        t.despedirse();
        t.cerrarServidor();

    }
}
