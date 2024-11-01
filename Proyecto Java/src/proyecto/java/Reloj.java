package proyecto.java;

import java.time.LocalTime;  

public class Reloj {

    public void mostrarHora() {
        try {
            LocalTime horaActual = LocalTime.now();
            int horas = horaActual.getHour();
            int minutos = horaActual.getMinute();
            int segundos = horaActual.getSecond();

            System.out.printf("Hora actual: %02d:%02d:%02d\n", horas, minutos, segundos);
        } catch (Exception e) {
            System.out.println("Error al obtener la hora: " + e.getMessage());
        }
    }
}