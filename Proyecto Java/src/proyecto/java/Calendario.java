package proyecto.java;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario {

    public void mostrarCalendario(int mes, int anio) {
        
        Calendar calendar = new GregorianCalendar(anio, mes - 1, 1);

        
        String[] nombresMeses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        String nombreMes = nombresMeses[mes - 1];

        
        System.out.printf("     %s %d\n", nombreMes, anio);
        System.out.println("Do Lu Ma Mi Ju Vi Sa");

        
        int primerDiaDelMes = calendar.get(Calendar.DAY_OF_WEEK);
        
        
        for (int i = 1; i < primerDiaDelMes; i++) {
            System.out.print("   ");
        }

        
        int diasEnMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

       
        for (int dia = 1; dia <= diasEnMes; dia++) {
            System.out.printf("%2d ", dia);

            
            if ((dia + primerDiaDelMes - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}