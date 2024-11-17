package HomeWork_07_11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HumanReadableTimestampDuration {

    public static void main(String[] args) {
        LocalDate publishDate = LocalDate.now().minusDays(1);
        LocalTime publishTime = LocalTime.now().minusHours(5);
        LocalDateTime timestamp = LocalDateTime.of(publishDate, publishTime);

        HumanReadableTimestamp humanReadableTimestamp = new HumanReadableTimestampImpl();
        String humanReadable = humanReadableTimestamp.getTimestamp(timestamp);

        System.out.println(humanReadable);
    }
}
