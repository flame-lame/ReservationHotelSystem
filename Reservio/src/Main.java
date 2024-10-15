import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        // Guests -->
        Guest guest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest guest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest guest3 = new Guest("Karolína", "Tmavá", LocalDate.of(2000, 4, 8));

        // Rooms -->
        Room room1 = new Room(1, 1,true, true, new BigDecimal("1000"));
        Room room2 = new Room(2, 1,true, true, new BigDecimal("1000"));
        Room room3 = new Room(3, 3,false, true, new BigDecimal("2400"));

        BookingManager bookingManager = new BookingManager();
        List<Booking> bookings = bookingManager.getBookings();
        bookings.add(new Booking(room3, List.of(guest1), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), TypeOfVacation.Work, 1));
        bookings.add(new Booking(room2, List.of(guest2), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), TypeOfVacation.Joy, 1));
        bookings.add(new Booking(room3, List.of(guest3, guest1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), TypeOfVacation.Work, 2));

        for (int i = 1; i < 20; i += 2) {
            bookings.add(new Booking(room2, List.of(guest3), LocalDate.of(2023, 8, i), LocalDate.of(2023, 8, (i+1)), TypeOfVacation.Joy, 2));
        }

        int numberOfVacations = bookingManager.getNumberOfVacations();
        int numberOfJoyVacations = bookingManager.getNumberOfJoyVacations();
        int numberOfWorkVacations = bookingManager.getNumberOfWorkVacations();
        int oneGuest = bookingManager.getOneGuestBookings();
        int twoGuest = bookingManager.getTwoGuestBookings();

        int totalGuests = 0;
        for (Booking booking : bookings) {
            totalGuests += booking.getGuest().size();
        }

        System.out.println("---> Vacation statistics");
        System.out.println("Number of vacations: " + numberOfVacations);
        System.out.println("Joy vacations: " + numberOfJoyVacations);
        System.out.println("Work vacations: " + numberOfWorkVacations);
        System.out.println("--->");
        System.out.println("One guest per room: " + oneGuest);
        System.out.println("Two guests per room: " + twoGuest);
        System.out.println("Total guests: " + totalGuests);
        if (numberOfVacations != 0) {
            System.out.println("Average guests: " + String.format("%.2f", (double) totalGuests / numberOfVacations));
        } else {
            System.out.println("Average guests: N/A (no vacations)");
        }
        System.out.println("--->");
        System.out.println("Available vacations");
        for (Booking booking : bookings) {
            if (bookingManager.isAvailable(booking.getRoom(), booking.getFromDate(), booking.getToDate())) {
                LocalDateTransform fromDate = new LocalDateTransform(booking.getFromDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                LocalDateTransform toDate = new LocalDateTransform(booking.getToDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                //bookingManager.addBooking(booking);
                //System.out.println("Vacation from: " + fromDate.getFormattedDate() + " Vacation to: " + toDate.getFormattedDate() + " Guest name: " + booking.getGuest()  + " Nights: " +  booking.getNights() + " Price: " +  booking.getPrice());
            } else {
                System.out.println("Its booked, please choose another dates.");
            }
        }

        System.out.println("--->");
        System.out.println("First eight Joy vacations");
        bookingManager.getFirstEightJoyVacations();
        System.out.println("--->");
        //bookingManager.printAllBookings();


    }

}