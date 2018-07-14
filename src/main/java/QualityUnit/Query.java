package QualityUnit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Query extends AbstractData{

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateFrom(String dateFrom) {

        this.dateFrom = LocalDate.parse(dateFrom, DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN));
    }

    public void setDateTo(String dateTo) {

        this.dateTo = LocalDate.parse(dateTo, DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN));
    }

    @Override
    public String toString() {
        return "Query{" + super.toString() +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                "} ";
    }
}
