/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reserva_hotel;

/**
 *
 * @author alex_
 */
import java.util.Scanner;

// Clase Hotel que representa el hotel y las habitaciones
class Hotel {
    private boolean[] habitaciones;

    public Hotel(int numHabitaciones) {
        habitaciones = new boolean[numHabitaciones];
        for (int i = 0; i < numHabitaciones; i++) {
            habitaciones[i] = true; // Todas las habitaciones inicialmente disponibles
        }
    }
 public int reservarHabitacion() {
        for (int i = 0; i < habitaciones.length; i++) {
            if (habitaciones[i]) {
                habitaciones[i] = false;
                return i + 1; // Número de habitación (índice + 1)
            }
        }
        return -1; // No hay habitaciones disponibles
    }

    public void mostrarDisponibilidad() {
        System.out.println("Disponibilidad de habitaciones:");
        for (int i = 0; i < habitaciones.length; i++) {
            System.out.println("Habitación " + (i + 1) + ": " + (habitaciones[i] ? "Disponible" : "Ocupada"));
        }
    }
}

// Clase principal que contiene el programa principal
public class ReservaHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de habitaciones en el hotel: ");
        int numHabitaciones = scanner.nextInt();
        Hotel hotel = new Hotel(numHabitaciones);
        System.out.println("Bienvenidos a Hotel Booking");
        System.out.println(" ¿Que desea hacer?");
        int opcion;
        do {
            
            System.out.println( "\nMenu de Reserva de Hotel");
            System.out.println("1. Reservar habitacion");
            System.out.println("2. Mostrar disponibilidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int numHabitacion = hotel.reservarHabitacion();
                    if (numHabitacion != -1) {
                        System.out.println("Habitacion " + numHabitacion + " reservada con exito.");
                    } else {
                        System.out.println("Lo siento, no hay habitaciones disponibles.");
                    }
                    break;
                case 2:
                    hotel.mostrarDisponibilidad();
                    break;
                case 0:
                    System.out.println(" ¡Gracias por reservar en Hotel Booking, vuelva pronto!");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}

