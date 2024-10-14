import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.String;

public class LocalDateTransform {
    private LocalDate date;
    private DateTimeFormatter formatter;
    private String formattedDate;

    public LocalDateTransform(LocalDate date, DateTimeFormatter formatter) {
        this.date = date;
        this.formatter = formatter;
        this.formattedDate = date.format(formatter);
    }

    public String getFormattedDate() {
        return this.formattedDate;
    }
}