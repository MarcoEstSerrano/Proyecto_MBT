package proyecto.java;

import java.util.Scanner;

public class Calculadora {

    public void realizarOperacion(Scanner entrada) {
        int opcion;

        do {
            
            System.out.println("-------CALCULADORA-------:");
            System.out.println("Seleccione una operacion:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer numero: ");
                double num1 = entrada.nextDouble();
                System.out.print("Ingrese el segundo numero: ");
                double num2 = entrada.nextDouble();

                double resultado = 0;
                boolean operacionValida = true;

                switch (opcion) {
                    case 1 -> resultado = sumar(num1, num2);
                    case 2 -> resultado = restar(num1, num2);
                    case 3 -> resultado = multiplicar(num1, num2);
                    case 4 -> {
                        if (num2 != 0) {
                            resultado = dividir(num1, num2);
                        } else {
                            System.out.println("Error: No se puede dividir entre cero.");
                            operacionValida = false;
                        }
                    }
                }

                if (operacionValida) {
                    System.out.println("Resultado: " + resultado);
                }
            } else if (opcion != 5) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 5);

        System.out.println("Saliendo de la calculadora...");
    }

    private double sumar(double a, double b) {
        return a + b;
    }

    private double restar(double a, double b) {
        return a - b;
    }

    private double multiplicar(double a, double b) {
        return a * b;
    }

    private double dividir(double a, double b) {
        return a / b;
    }
}