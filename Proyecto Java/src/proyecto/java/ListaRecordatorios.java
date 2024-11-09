package proyecto.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaRecordatorios {
    private List<Recordatorios> recordatorios;  // Cambiado de ListaRecordatorios a Recordatorios

    public ListaRecordatorios() {
        this.recordatorios = new ArrayList<>();
    }

    public void agregarRecordatorio(Scanner entrada) {
        System.out.print("Ingrese la descripción del recordatorio: ");
        String descripcion = entrada.nextLine();

        Recordatorios nuevoRecordatorio = new Recordatorios(descripcion);
        recordatorios.add(nuevoRecordatorio);
        System.out.println("Recordatorio agregado exitosamente.");
    }

    public void mostrarRecordatorios() {
        if (recordatorios.isEmpty()) {
            System.out.println("No hay recordatorios.");
        } else {
            System.out.println("Lista de recordatorios:");
            for (int i = 0; i < recordatorios.size(); i++) {
                System.out.println((i + 1) + ". " + recordatorios.get(i).getDescripcion());
            }
        }
    }

    public void eliminarRecordatorio(Scanner entrada) {
        mostrarRecordatorios();
        if (!recordatorios.isEmpty()) {
            System.out.print("Ingrese el número del recordatorio a eliminar: ");
            int indice = entrada.nextInt();
            entrada.nextLine(); // Limpiar buffer
            if (indice > 0 && indice <= recordatorios.size()) {
                recordatorios.remove(indice - 1);
                System.out.println("Recordatorio eliminado.");
            } else {
                System.out.println("Número no válido.");
            }
        }
    }
}