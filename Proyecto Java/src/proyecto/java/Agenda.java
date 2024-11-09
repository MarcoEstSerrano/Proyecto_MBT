package proyecto.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Agenda {

    private Contacto[] contactos;  
    private int cantidadContactos; 
    
    public Agenda(int capacidad) {
        this.contactos = new Contacto[capacidad]; 
        this.cantidadContactos = 0;  
    }

    public void agregarContacto(Scanner entrada) {
        boolean agregarOtro = true;

        while (agregarOtro && cantidadContactos < contactos.length) {
            System.out.println("Ingrese la informacion del contacto:");
            
            System.out.print("Nombre: ");
            String nombre = entrada.next();
            
            
            int edad = 0;
            while (true) {
                System.out.print("Edad: ");
                try {
                    edad = entrada.nextInt();
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número para la edad. Intente de nuevo.");
                    entrada.next();
                }
            }
            
           
            int telefono = 0;
            while (true) {
                System.out.print("Telefono: ");
                try {
                    telefono = entrada.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Se produjo un error: Debe ingresar un número para el teléfono. Intente de nuevo.");
                    entrada.next();
                }
            }
            
            System.out.print("Correo electronico: ");
            String correoElectronico = entrada.next();
            
            System.out.print("Notas: ");
            String notas = entrada.next();
            
            contactos[cantidadContactos] = new Contacto(nombre, edad, telefono, correoElectronico, notas);
            cantidadContactos++;
            
            System.out.println("Contacto agregado con exito.\n");
            
            System.out.print("¿Desea agregar otro contacto? (s/n): ");
            String respuesta = entrada.next();
            agregarOtro = respuesta.equalsIgnoreCase("s");
        }

        if (cantidadContactos == contactos.length) {
            System.out.println("La agenda esta llena. No se pueden agregar mas contactos.");
        }
    }

    public void mostrarContactos() {
        if (cantidadContactos == 0) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            System.out.println("Lista de contactos:");
            for (int i = 0; i < cantidadContactos; i++) {
                System.out.println("Contacto " + (i + 1) + ":");
                System.out.println("Nombre: " + contactos[i].getNombre());
                System.out.println("Edad: " + contactos[i].getEdad());
                System.out.println("Telefono: " + contactos[i].getTelefono());
                System.out.println("Correo electronico: " + contactos[i].getCorreoElectronico());
                System.out.println("Notas: " + contactos[i].getNotas());
                System.out.println(" ");
            }
        }
    }

    public void modificarContacto(Scanner entrada) {
        if (cantidadContactos == 0) {
            System.out.println("No hay contactos en la agenda para modificar.");
            return;
        }
        
        mostrarContactos();
        
        int indice = -1;
        while (true) {
            System.out.print("Ingrese el número del contacto que desea modificar: ");
            try {
                indice = entrada.nextInt() - 1;
                if (indice < 0 || indice >= cantidadContactos) {
                    throw new IndexOutOfBoundsException("Número de contacto inválido.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                entrada.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        Contacto contacto = contactos[indice];
        
        System.out.println("Modificando el contacto " + (indice + 1) + ":");
        System.out.print("Nuevo nombre (actual: " + contacto.getNombre() + "): ");
        String nombre = entrada.next();
        
     
        int edad = 0;
        while (true) {
            System.out.print("Nueva edad (actual: " + contacto.getEdad() + "): ");
            try {
                edad = entrada.nextInt();
                contacto.setEdad(edad);
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número para la edad. Intente de nuevo.");
                entrada.next(); 
            }
        }
        
        
        int telefono = 0;
        while (true) {
            System.out.print("Nuevo telefono (actual: " + contacto.getTelefono() + "): ");
            try {
                telefono = entrada.nextInt();
                contacto.setTelefono(telefono);
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número para el teléfono. Intente de nuevo.");
                entrada.next(); 
            }
        }
        
        System.out.print("Nuevo correo electronico (actual: " + contacto.getCorreoElectronico() + "): ");
        String correo = entrada.next();
        contacto.setCorreoElectronico(correo);
        
        System.out.print("Nuevas notas (actual: " + contacto.getNotas() + "): ");
        String notas = entrada.next();
        contacto.setNotas(notas);
        
        System.out.println("Contacto modificado con éxito.\n");
    }
}