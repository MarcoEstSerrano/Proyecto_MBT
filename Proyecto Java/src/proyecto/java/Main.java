package proyecto.java;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    private static String contrasena = "123";

    public static void main(String[] args) {
        mostrarBannerMBT();

        int opcionMenuPrincipal;
        do {
            
            String menuPrincipal = "-------MENÚ PRINCIPAL-------:\n"
                    + "1. Cambiar contraseña\n"
                    + "2. Ingresar al programa\n"
                    + "3. Salir\n"
                    + "Seleccione una opción:";
            
            try {
                String input = JOptionPane.showInputDialog(menuPrincipal);
               
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Has cerrado el programa. Gracias por usar MBT.");
                    break; 
                }
                opcionMenuPrincipal = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida.", "Error", JOptionPane.ERROR_MESSAGE);
                opcionMenuPrincipal = 0;  
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
                opcionMenuPrincipal = 0; 
            }

            switch (opcionMenuPrincipal) {
                case 1:
                    cambiarContrasena();
                    break;
                case 2:
                    ingresarAlPrograma();
                    break;
                case 3:
                    System.out.println("Cerrando sistema MBT...");
                    JOptionPane.showMessageDialog(null, "Has cerrado el programa. Gracias por usar MBT.");
                    break; 
                    
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionMenuPrincipal != 3);
    }

    private static void ingresarAlPrograma() {
        String contrasenaIngresada = null;
        try {
            contrasenaIngresada = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la contraseña para acceder a MBT:",
                    "Verificación de Contraseña",
                    JOptionPane.INFORMATION_MESSAGE);

            // Si el usuario presiona le da click al boton de cancelar :)
            if (contrasenaIngresada == null) {
                JOptionPane.showMessageDialog(null, "Has cerrado el programa. Gracias por usar MBT.");
                return;  // Cierra completamente todo
            }

            if (!contrasenaIngresada.equals(contrasena)) {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Acceso denegado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            // cualquier otra excepción:
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
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

            String mensaje = String.format("Bienvenido a My Blackboard Tools (MBT)");
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
                    String input = JOptionPane.showInputDialog(menuPrincipalProgram);
                    if (input == null) {
                        JOptionPane.showMessageDialog(null, "Has cerrado el programa. Gracias por usar MBT.");
                        break;  
                    }
                    opcionPrincipal = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    opcionPrincipal = 0;  
                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
                    opcionPrincipal = 0; 
                }

                switch (opcionPrincipal) {
                    case 1 -> menuAgenda(entrada, miAgenda);
                    case 2 -> menuCalendario(entrada, miCalendario);
                    case 3 -> menuRecordatorios(entrada, miListaRecordatorios);
                    case 4 -> menuReloj(entrada, miReloj);
                    case 5 -> menuPizarra(entrada, miPizarraDeNotas);
                    case 6 -> miCalculadora.realizarOperacion(entrada);
                    case 7 -> cambiarContrasena();
                    case 8 -> System.out.println("Volviendo al menu inicial...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcionPrincipal != 8);
        }
    }

    

    private static void menuAgenda(Scanner entrada, Agenda miAgenda) {
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
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionAgenda != 4);
    }

    private static void menuCalendario(Scanner entrada, Calendario miCalendario) {
        System.out.print("Ingrese el año: ");
        int anio = entrada.nextInt();
        System.out.print("Ingrese el mes (1-12): ");
        int mes = entrada.nextInt();
        miCalendario.mostrarCalendario(mes, anio);
    }

    private static void menuRecordatorios(Scanner entrada, ListaRecordatorios miListaRecordatorios) {
        int opcionRecordatorios;
        do {
            System.out.println("-------RECORDATORIOS-------:");
            System.out.println("1. Agregar recordatorio");
            System.out.println("2. Mostrar recordatorios");
            System.out.println("3. Eliminar recordatorio");
            System.out.println("4. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcionRecordatorios = entrada.nextInt();
            entrada.nextLine(); // consume the leftover newline character

            switch (opcionRecordatorios) {
                case 1 -> miListaRecordatorios.agregarRecordatorio(entrada);
                case 2 -> miListaRecordatorios.mostrarRecordatorios();
                case 3 -> miListaRecordatorios.eliminarRecordatorio(entrada);
                case 4 -> System.out.println("Volviendo al menu principal...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionRecordatorios != 4);
    }

    private static void menuReloj(Scanner entrada, Reloj miReloj) {
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

    private static void menuPizarra(Scanner entrada, PizarraDeNotas miPizarraDeNotas) {
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

    private static void cambiarContrasena() {
    String contrasenaActual = JOptionPane.showInputDialog(
            null,
            "Ingrese su contraseña actual:",
            "Cambio de Contraseña",
            JOptionPane.INFORMATION_MESSAGE);

    
    if (contrasenaActual == null) {
        JOptionPane.showMessageDialog(null, "Cambio de contraseña cancelado.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    if (!contrasenaActual.equals(contrasena)) {
        JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta. No se puede cambiar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

  String nuevaContrasena = JOptionPane.showInputDialog(
            null,
            "Ingrese la nueva contraseña:",
            "Cambio de Contraseña",
            JOptionPane.INFORMATION_MESSAGE);

    if (nuevaContrasena == null) {
        JOptionPane.showMessageDialog(null, "Cambio de contraseña cancelado.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    String confirmacionContrasena = JOptionPane.showInputDialog(
            null,
            "Confirme la nueva contraseña:",
            "Cambio de Contraseña",
            JOptionPane.INFORMATION_MESSAGE);

   if (confirmacionContrasena == null || !nuevaContrasena.equals(confirmacionContrasena)) {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    contrasena = nuevaContrasena;
    JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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