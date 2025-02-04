package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();

            System.out.print("Check-in date (DD/MM/YYYY): ");
            LocalDate checkInDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Check-out date (DD/MM/YYYY): ");
            LocalDate checkOutDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println("Reservation completed!");
            System.out.println(reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation");

            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkInDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOutDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            reservation.updateDates(checkInDate, checkOutDate);

            System.out.println();
            System.out.println("Reservation updated!");
            System.out.println(reservation);

        } catch (DateTimeParseException e) {
            System.out.println("Invalid text format");
        } catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    }
}
