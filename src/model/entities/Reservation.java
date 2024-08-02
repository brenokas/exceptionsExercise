package model.entities;

import model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Reservation(Integer roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        if (!checkOutDate.isAfter(checkInDate)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }

        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public long duration() {
        Duration duration = Duration.between(checkInDate.atStartOfDay(), checkOutDate.atStartOfDay());
        return duration.toDays();
    }

    public void updateDates(LocalDate checkInDate, LocalDate checkOutDate) {
        LocalDate now = LocalDate.now();
        if (checkInDate.isBefore(now) || checkOutDate.isBefore(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }

        if (!checkOutDate.isAfter(checkInDate)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }

        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return " -> Room: " + roomNumber + "\n" +
                " -> Check-in date: " + checkInDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                " -> Check-out date: " + checkOutDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                " -> Duration: " + duration() + " nights";
    }
}
