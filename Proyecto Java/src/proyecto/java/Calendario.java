package proyecto.java;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario {

    public void mostrarCalendario(int mes, int anio) {
        // Crear un calendario configurado para el primer día del mes y año especificados
        Calendar calendar = new GregorianCalendar(anio, mes - 1, 1);

        // Obtener el nombre del mes
        String[] nombresMeses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        String nombreMes = nombresMeses[mes - 1];

        // Imprimir encabezado del calendario
        System.out.printf("     %s %d\n", nombreMes, anio);
        System.out.println("Do Lu Ma Mi Ju Vi Sa");

        // Calcular el día de la semana del primer día del mes
        int primerDiaDelMes = calendar.get(Calendar.DAY_OF_WEEK);
        
        // Ajustar el inicio del calendario a la posición del primer día
        for (int i = 1; i < primerDiaDelMes; i++) {
            System.out.print("   ");
        }

        // Obtener el número de días en el mes
        int diasEnMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Imprimir los días del mes
        for (int dia = 1; dia <= diasEnMes; dia++) {
            System.out.printf("%2d ", dia);

            // Saltar a la siguiente línea después de imprimir sábado
            if ((dia + primerDiaDelMes - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Salto de línea final
    }
}