import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();;
    int numberOfGuests;

    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
        } else {
            System.out.println("Cannot add null booking.");
        }
        this.numberOfGuests = numberOfGuests;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Booking getBooking(int index) {
        return bookings.get(index);
    }

    public Booking getFirst() {
        return bookings.get(0);
    }

    public int getNumberOfJoyVacations() {
        int numberOfJoyVacations = 0;
        for (Booking booking : bookings) {
            TypeOfVacation typeOfVacation = booking.getTypeOfVacation();
            if (typeOfVacation == TypeOfVacation.Joy) {
                numberOfJoyVacations++;
            }
        }
        return numberOfJoyVacations;
    }

    public int getNumberOfWorkVacations() {
        int numberOfWorkVacations = 0;
        for (Booking booking : bookings) {
            TypeOfVacation typeOfVacation = booking.getTypeOfVacation();
            if (typeOfVacation == TypeOfVacation.Work) {
                numberOfWorkVacations++;
            }
        }
        return numberOfWorkVacations;
    }

    public int getNumberOfVacations() {
        return getNumberOfJoyVacations() + getNumberOfWorkVacations();
    }


    public List<Booking> getFirstEightJoyVacations() {
        List<Booking> firstEightJoyVacations = new ArrayList<>();
        int counter = 0;
        for (Booking booking : bookings) {
            if (booking.getTypeOfVacation() == TypeOfVacation.Joy) {
                firstEightJoyVacations.add(booking);
                counter++;
                System.out.println(booking.getFromDate() + " - " + booking.getToDate() + " : " + booking.getGuest() + " : "+ booking.getPrice() + " CZK");
                if (counter == 8) {
                    break;
                }
            }
        }
        return firstEightJoyVacations;
    }

    public int getOneGuestBookings() {
        int numberOfOneGuestBookings = 0;
        for (Booking booking : bookings) {
            if (booking.getNumberOfGuests() == 1) {
                numberOfOneGuestBookings++;
            }
        }
        return numberOfOneGuestBookings;
    }

    public int getTwoGuestBookings() {
        int numberOfTwoGuestBookings = 0;
        for (Booking booking : bookings) {
            if (booking.getNumberOfGuests() == 2) {
                numberOfTwoGuestBookings++;
            }
        }
        return numberOfTwoGuestBookings;
    }

    public void clearBookings() {
        bookings.clear();
    }

    public void printAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public boolean isAvailable(Room room, LocalDate fromDate, LocalDate toDate) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room) &&
                    !(toDate.isBefore(booking.getFromDate()) || fromDate.isAfter(booking.getToDate()))) {
                return false;
            }
        }
        return true;
    }

}
