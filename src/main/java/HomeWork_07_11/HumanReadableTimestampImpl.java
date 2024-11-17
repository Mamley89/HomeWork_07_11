package HomeWork_07_11;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.*;

public class HumanReadableTimestampImpl implements HumanReadableTimestamp {

    @Override
    public String getTimestamp(LocalDateTime eventTimestamp) {
        LocalDateTime now = LocalDateTime.now();
        if (now.minusDays(1).isEqual(eventTimestamp)) {
            return "опубликовано вчера";
        }
        if (now.minusDays(1).isBefore(eventTimestamp)) {
            if (now.minusHours(1).isBefore(eventTimestamp)) {
                Integer minutes = ((Long) MINUTES.between(eventTimestamp.toLocalTime(), now.toLocalTime())).intValue();
                String minutesText = switch (minutes) {
                    case 2, 3, 4, 22, 54 -> "минуты";
                    case 1, 21, 31, 41, 51 -> "минуту";
                    default -> "минут";
                };
                return "опубликовано " + minutes + " " + minutesText + " назад";
            }
            Integer hours = ((Long) HOURS.between(eventTimestamp.toLocalTime(), now.toLocalTime())).intValue();
            String hoursText = switch (hours) {
                case 1, 21 -> "час";
                case 2, 3, 4, 22, 23 -> "часа";
                default -> "часов";
            };
            return "опубликовано " + hours + " " + hoursText + " назад";
        }
        Integer days = ((Long) DAYS.between(eventTimestamp, now)).intValue();
        String daysText = switch (days) {
            case 5, 20, 99, 100, 111 -> "дней";
            case 2, 3, 4, 22, 23, 92 -> "дня";
            default -> "день";
        };
        return "опубликовано " + days + " " + daysText + " назад";
    }
}
