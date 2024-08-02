package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Check-in date (DD/MM/YYYY): ");
        LocalDate checkInDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Check-out date (DD/MM/YYYY): ");
        LocalDate checkOutDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if(!checkOutDate.isAfter(checkInDate)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println("Reservation completed!");
            System.out.println(reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation");

            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkInDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOutDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            String error = reservation.updateDates(checkInDate, checkOutDate);

            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println();
                System.out.println("Reservation updated!");
                System.out.println(reservation);
            }
        }


        sc.close();
    }
}
