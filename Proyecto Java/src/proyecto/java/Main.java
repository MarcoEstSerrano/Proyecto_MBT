package proyecto.java;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    private static String contrasena = "supercontraseña";

    public static void main(String[] args) {
        mostrarBannerMBT();

        String contrasenaIngresada = JOptionPane.showInputDialog(
                null,
                "Ingrese la contraseña para acceder a MBT:",
                "Verificación de Contraseña",
                JOptionPane.INFORMATION_MESSAGE);

        if (contrasenaIngresada == null || !contrasenaIngresada.equals(contrasena)) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Acceso denegado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Scanner entrada = new Scanner(System.in)) {
            Agenda miAgenda = new Agenda(5);
            Reloj miReloj = new Reloj();
            Calculadora miCalculadora = new Calculadora(); 
            PizarraDeNotas miPizarraDeNotas = new PizarraDeNotas();

            String nombre = JOptionPane.showInputDialog(
                    null,
                    "Ingrese su nombre",
                    "Informacion personal",
                    JOptionPane.INFORMATION_MESSAGE);
            
            String mensaje = String.format("Bienvenido %s a My Blackboard Tools (MBT)", nombre);
            
            JOptionPane.showMessageDialog(
                    null,
                    mensaje,
                    "MBT",
                    JOptionPane.INFORMATION_MESSAGE);
            
            int opcionPrincipal;
            
            do {
                System.out.println("-------MENU-------:");
                System.out.println("1. Contactos favoritos");
                System.out.println("2. Calendario");
                System.out.println("3. Recordatorios");
                System.out.println("4. Reloj");
                System.out.println("5. Pizarra de notas");
                System.out.println("6. Calculadora");
                System.out.println("7. Cambiar contrasena");
                System.out.println("8. Salir");

                System.out.print("Seleccione una opcion: ");
                opcionPrincipal = entrada.nextInt();
                entrada.nextLine();
                
                switch (opcionPrincipal) {
                    case 1 -> {
                        int opcionAgenda;
                        do {
                            System.out.println("-------AGENDA-------:");
                            System.out.println("1. Agregar contacto a la agenda");
                            System.out.println("2. Mostrar contactos");
                            System.out.println("3. Modificar contacto");
                            System.out.println("4. Volver al menu principal");
                            System.out.print("Seleccione una opcion: ");
                            opcionAgenda = entrada.nextInt();

                            switch (opcionAgenda) {
                                case 1 -> miAgenda.agregarContacto(entrada);
                                case 2 -> miAgenda.mostrarContactos();
                                case 3 -> miAgenda.modificarContacto(entrada);
                                case 4 -> System.out.println("Volviendo al menu principal...");
                                default -> System.out.println("Opcion no valida. Intente de nuevo.");
                            }
                        } while (opcionAgenda != 4);
                    }
                    case 2 -> System.out.println("Funcionalidad de Calendario aún no implementada.");
                    case 3 -> System.out.println("Funcionalidad de Recordatorios aún no implementada.");
                    case 4 -> {
                        int opcionReloj;
                        do {
                            System.out.println("-------RELOJ-------:");
                            System.out.println("1. Ver Reloj");
                            System.out.println("2. Volver al menu principal");
                            System.out.print("Seleccione una opcion: ");
                            opcionReloj = entrada.nextInt();

                            switch (opcionReloj) {
                                case 1 -> miReloj.mostrarHora();
                                case 2 -> System.out.println("Volviendo al menu principal...");
                                default -> System.out.println("Opción no válida. Intente de nuevo.");
                            }
                        } while (opcionReloj != 2);
                    }
                    case 5 -> {
                        int opcionPizarra;
                        do {
                            System.out.println("-------PIZARRA DE NOTAS-------:");
                            System.out.println("1. Agregar nota");
                            System.out.println("2. Mostrar notas");
                            System.out.println("3. Eliminar nota");
                            System.out.println("4. Volver al menu principal");
                            System.out.print("Seleccione una opcion: ");
                            opcionPizarra = entrada.nextInt();

                            switch (opcionPizarra) {
                                case 1 -> miPizarraDeNotas.agregarNota(entrada);
                                case 2 -> miPizarraDeNotas.mostrarNotas();
                                case 3 -> miPizarraDeNotas.eliminarNota(entrada);
                                case 4 -> System.out.println("Volviendo al menu principal...");
                                default -> System.out.println("Opción no válida. Intente de nuevo.");
                            }
                        } while (opcionPizarra != 4);
                    }
                    case 6 -> miCalculadora.realizarOperacion(entrada);
                    case 7 -> cambiarContrasena();
                    case 8 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcionPrincipal != 8);
        }  
    }

    private static void cambiarContrasena() {
        String contrasenaActual = JOptionPane.showInputDialog(
                null,
                "Ingrese su contraseña actual:",
                "Cambio de Contraseña",
                JOptionPane.INFORMATION_MESSAGE);

        if (contrasenaActual != null && contrasenaActual.equals(contrasena)) {
            String nuevaContrasena = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la nueva contraseña:",
                    "Cambio de Contraseña",
                    JOptionPane.INFORMATION_MESSAGE);

            String confirmacionContrasena = JOptionPane.showInputDialog(
                    null,
                    "Confirme la nueva contraseña:",
                    "Cambio de Contraseña",
                    JOptionPane.INFORMATION_MESSAGE);

            if (nuevaContrasena != null && nuevaContrasena.equals(confirmacionContrasena)) {
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
}