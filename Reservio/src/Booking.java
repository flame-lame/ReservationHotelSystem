import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.lang.String;


public class Booking {
    private Room room;
    private List<Guest> guests;
    private LocalDate fromDate;
    private LocalDate toDate;
    private TypeOfVacation typeOfVacation;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    //private int numberOfGuests;
    //private int guest;
    //private List<Reservation> reservations;

    public Booking(Room room, List<Guest> guests, LocalDate fromDate, LocalDate toDate, TypeOfVacation typeOfVacation /* int numberOfGuests */, int guest) {
        this.room = room;
        this.guests = guests;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.typeOfVacation = typeOfVacation;
        //this.numberOfGuests = numberOfGuests;
        //this.guest = guest;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public Room getRoom() {
        return room;
    }

    public List<Guest> getGuest() {
        return guests;
    }

    public TypeOfVacation getTypeOfVacation() {
        return typeOfVacation;
    }

    public int getNights() {
        return (int) ChronoUnit.DAYS.between(fromDate, toDate);
    }

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(getNights()).multiply(room.getPrice());
    }

    @Override
    public String toString() {
        LocalDateTransform dateFrom = new LocalDateTransform(fromDate, formatter);
        LocalDateTransform dateTo = new LocalDateTransform(toDate, formatter);
        return "Room nmb:  " + room + ", Guests: " + guests + ", From: " + dateFrom.getFormattedDate() + ", To: " + dateTo.getFormattedDate() + ", Type of Vacation: " + typeOfVacation;
    }

    public int getNumberOfGuests() {
        return guests.size();
    }
}
