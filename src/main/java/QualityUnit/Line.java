package QualityUnit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Line extends AbstractData {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofLocalizedDate(FormatStyle.MEDIUM)
            .withLocale(Locale.GERMAN);
    private LocalDate date;
    private int time;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, FORMATTER);
    }

    public int getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = Integer.parseInt(time);
    }

    @Override
    public String toString() {
        return "Line{" + super.toString() +
                ", date=" + date +
                ", time=" + time +
                "} ";
    }
}
