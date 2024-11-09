package proyecto.java;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    private static String contrasena = "123";

    public static void main(String[] args) {
        mostrarBannerMBT();

        int opcionMenuPrincipal;
        do {
            // Menú principal con opciones
            String menuPrincipal = "-------MENÚ PRINCIPAL-------:\n"
                    + "1. Cambiar contraseña\n"
                    + "2. Ingresar al programa\n"
                    + "3. Salir\n"
                    + "Seleccione una opción:";

            try {
                opcionMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "HA CERRADO EL PROGRAMA, GRACIAS POR USAR MBT.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            switch (opcionMenuPrincipal) {
                case 1:
                    cambiarContrasena();
                    break;
                case 2:
                    ingresarAlPrograma();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionMenuPrincipal != 3);
    }

    private static void ingresarAlPrograma() {
        String contrasenaIngresada = JOptionPane.showInputDialog(
                null,
                "Ingrese la contraseña para acceder a MBT:",
                "Verificación de Contraseña",
                JOptionPane.INFORMATION_MESSAGE);

        if (contrasenaIngresada == null || !contrasenaIngresada.equals(contrasena)) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Acceso denegado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Acceso al programa principal
        try (Scanner entrada = new Scanner(System.in)) {
            Agenda miAgenda = new Agenda(5);
            Reloj miReloj = new Reloj();
            Calculadora miCalculadora = new Calculadora();
            PizarraDeNotas miPizarraDeNotas = new PizarraDeNotas();
            Calendario miCalendario = new Calendario();
            ListaRecordatorios miListaRecordatorios = new ListaRecordatorios();

            String nombre = JOptionPane.showInputDialog(
                    null,
                    "Ingrese su nombre",
                    "Informacion personal",
                    JOptionPane.INFORMATION_MESSAGE);

            if (nombre == null) {
                JOptionPane.showMessageDialog(null, "Se ha presentado un error, por favor reinicie el programa.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String mensaje = String.format("Bienvenido %s a My Blackboard Tools (MBT)", nombre);
            JOptionPane.showMessageDialog(
                    null,
                    mensaje,
                    "MBT",
                    JOptionPane.INFORMATION_MESSAGE);

            int opcionPrincipal;
            do {
                String menuPrincipalProgram = "-------MENU-------:\n"
                        + "1. Contactos favoritos\n"
                        + "2. Calendario\n"
                        + "3. Recordatorios\n"
                        + "4. Reloj\n"
                        + "5. Pizarra de notas\n"
                        + "6. Calculadora\n"
                        + "7. Cambiar contraseña\n"
                        + "8. Salir\n"
                        + "Seleccione una opción:";

                try {
                    opcionPrincipal = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipalProgram));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Se ha presentado un error, por favor reinicie el programa.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                switch (opcionPrincipal) {
                    case 1 -> menuAgenda(entrada, miAgenda);
                    case 2 -> menuCalendario(entrada, miCalendario);
                    case 3 -> menuRecordatorios(entrada, miListaRecordatorios);
                    case 4 -> menuReloj(entrada, miReloj);
                    case 5 -> menuPizarra(entrada, miPizarraDeNotas);
                    case 6 -> miCalculadora.realizarOperacion(entrada);
                    case 7 -> cambiarContrasena();
                    case 8 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcionPrincipal != 8);
        }
    }

    // Métodos de menú restantes (agenda, calendario, recordatorios, etc.) siguen igual, pero con manejo de excepciones en las entradas si es necesario.

    private static void cambiarContrasena() {
        String contrasenaActual = JOptionPane.showInputDialog(
                null,
                "Ingrese su contraseña actual:",
                "Cambio de Contraseña",
                JOptionPane.INFORMATION_MESSAGE);

        if (contrasenaActual == null) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error, por favor reinicie el programa.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (contrasenaActual.equals(contrasena)) {
            String nuevaContrasena = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la nueva contraseña:",
                    "Cambio de Contraseña",
                    JOptionPane.INFORMATION_MESSAGE);

            if (nuevaContrasena == null) {
                JOptionPane.showMessageDialog(null, "Se ha presentado un error, por favor reinicie el programa.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String confirmacionContrasena = JOptionPane.showInputDialog(
                    null,
                    "Confirme la nueva contraseña:",
                    "Cambio de Contraseña",
                    JOptionPane.INFORMATION_MESSAGE);

            if (confirmacionContrasena == null) {
                JOptionPane.showMessageDialog(null, "Se ha presentado un error, por favor reinicie el programa.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nuevaContrasena.equals(confirmacionContrasena)) {
                contrasena = nuevaContrasena;
                JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarBannerMBT() {
        System.out.println(" __  __ ____ _____ ");
        System.out.println("|  \\/  | __ )_  _|");
        System.out.println("| |\\/| |  _ \\ | | ");
        System.out.println("| |  | | |_) || | ");
        System.out.println("|_|  |_|____/ |_| ");
        System.out.println();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void menuAgenda(Scanner entrada, Agenda miAgenda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void menuCalendario(Scanner entrada, Calendario miCalendario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void menuRecordatorios(Scanner entrada, ListaRecordatorios miListaRecordatorios) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void menuReloj(Scanner entrada, Reloj miReloj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void menuPizarra(Scanner entrada, PizarraDeNotas miPizarraDeNotas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}