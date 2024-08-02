package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        Duration duration = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
        return duration.toDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return " -> Room: " + roomNumber + "\n" +
                " -> Check-in date: " + checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                " -> Check-out date: " + checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                " -> Duration: " + duration() + " nights.";
    }
}
