package proyecto.java;

import java.util.ArrayList;
import java.util.Scanner;

public class PizarraDeNotas {
    
    private ArrayList<String> notas;

    public PizarraDeNotas() {
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Scanner entrada) {
       
        entrada.nextLine();

        System.out.print("Ingrese la nota: ");
        String nota = entrada.nextLine();
        notas.add(nota);
        System.out.println("Nota agregada con éxito.");
    }

    public void mostrarNotas() {
        if (notas.isEmpty()) {
            System.out.println("No hay notas en la pizarra.");
        } else {
            System.out.println("Notas en la pizarra:");
            for (int i = 0; i < notas.size(); i++) {
                System.out.println((i + 1) + ". " + notas.get(i));
            }
        }
    }

    public void eliminarNota(Scanner entrada) {
        mostrarNotas();
        if (!notas.isEmpty()) {
            System.out.print("Ingrese el número de la nota que desea eliminar: ");
            int indice = entrada.nextInt() - 1;

            if (indice < 0 || indice >= notas.size()) {
                System.out.println("Número de nota inválido.");
            } else {
                notas.remove(indice);
                System.out.println("Nota eliminada con éxito.");
            }
        }
    }
}