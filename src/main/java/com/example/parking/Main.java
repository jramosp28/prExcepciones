package com.example.parking;
import java.util.Scanner;

/**
 *
 * @author javierrampob
 */

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking("Parking Centro", 10);
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 4) {
            try {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Entrada de coche");
                System.out.println("2. Salida de coche");
                System.out.println("3. Mostrar parking");
                System.out.println("4. Salir del programa");
                System.out.print("Selecciona una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce la matrícula del coche: ");
                        String matriculaEntrada = scanner.nextLine();
                        System.out.print("Introduce la plaza donde se colocará: ");
                        int plazaEntrada = Integer.parseInt(scanner.nextLine());

                        try {
                            parking.entrada(matriculaEntrada, plazaEntrada);
                            System.out.println("Entrada realizada con éxito.");
                            System.out.println("Plazas totales: " + parking.getPlazasTotales());
                            System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                            System.out.println("Plazas libres: " + parking.getPlazasLibres());
                        } catch (ParkingException e) {
                            System.out.println("Error: " + e.getMensaje());
                            System.out.println("Matrícula: " + e.getMatricula());
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Introduce la matrícula del coche que sale: ");
                        String matriculaSalida = scanner.nextLine();

                        try {
                            int plazaLiberada = parking.salida(matriculaSalida);
                            System.out.println("Salida realizada con éxito.");
                            System.out.println("Plazas totales: " + parking.getPlazasTotales());
                            System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                            System.out.println("Plazas libres: " + parking.getPlazasLibres());
                        } catch (ParkingException e) {
                            System.out.println("Error: " + e.getMensaje());
                            System.out.println("Matrícula: " + e.getMatricula());
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println(parking.toString());
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida. Introduce un número del 1 al 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: La opción ingresada no es un número entero.");
            }
        }

        scanner.close();
    }
}