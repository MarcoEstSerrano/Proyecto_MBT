package proyecto.java;

import java.util.ArrayList;


public class Recordatorios {
    private ArrayList<String> recordatorios;

    
    public Recordatorios() {
        recordatorios = new ArrayList<>();
    }

    
    public void agregarRecordatorio(String recordatorio) {
        recordatorios.add(recordatorio);
        System.out.println("Recordatorio agregado: " + recordatorio);
    }

    
    public void mostrarRecordatorios() {
        if (recordatorios.isEmpty()) {
            System.out.println("No hay recordatorios.");
            return;
        }
        System.out.println("Recordatorios:");
        for (String r : recordatorios) {
            System.out.println("- " + r);
        }
    }
}
