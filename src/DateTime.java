import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Locale;


public class DateTime {
    //файл DateTime.txt
    // для 5 задачи
    public static int countWeekends(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        int dayMonth = yearMonth.lengthOfMonth();
        int Count = 0;
        for (int day = 1; day <= dayMonth; day++) {
            LocalDate date = LocalDate.of(year, month, day);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                Count++;
            }
        }
        return Count;
    }

    //файл DateTime.txt
    // для 8 задачи
    public static String convertUtcToMoscow(String utcdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(utcdate, formatter);
        ZonedDateTime utcZonedDateTime = localDateTime.atZone(ZoneId.of("UTC"));
        ZonedDateTime moscow = utcZonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        return moscow.format(formatter);
    }

    //файл DateTime.txt
    // для 10 задачи
    public static void MonthCalendar(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysMonth = yearMonth.lengthOfMonth();
        System.out.println("Календарь " + month + "/" + year);
        for (int day = 1; day <= daysMonth; day++) {
            LocalDate date = LocalDate.of(year, month, day);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            boolean flag = (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);
            String dayType = flag ? "Выходной" : "Рабочий день";
            System.out.println(date + " - " + dayOfWeek + " - " + dayType);
        }
    }

    public static void main(String[] args) {
//        файл DateTime.txt
//        задача 1
//        LocalDate date = LocalDate.now();
//        int year = date.getYear();
//        int month = date.getMonthValue();
//        int day = date.getDayOfMonth();
//        System.out.println(date);
//        LocalTime time = LocalTime.now();
//        System.out.println(time);
        //задача 2
//        LocalDate date1 = LocalDate.of(2024, 7, 3);
//        LocalDate date2 = LocalDate.of(2025, 7, 6);
//        int y1 = date1.getYear();
//        int y2 = date2.getYear();
//        int m1 = date1.getMonthValue();
//        int m2 = date2.getMonthValue();
//        int d1 = date1.getDayOfMonth();
//        int d2 = date2.getDayOfMonth();
//        if(y1==y2 && m1==m2 && d1==d2){
//            System.out.println("Даты равны");
//        }else if(y1>y2 || y1==y2 && m1>m2 || y1==y2 && m1==m2 && d1>d2){
//            System.out.print(date1 + " - эта дата больше");
//        }else{
//            System.out.print(date2 + " - эта дата больше");
//        }
        //задача 3
//        LocalDate date = LocalDate.of(2025, 12, 30);
//        int n = date.getDayOfYear();
//        System.out.print(365-n + " дней/день осталось до Нового года!");
        //задача 4
//        int y1 = 2024;
//        LocalDate date = LocalDate.of(y1, 12, 31);
//        int n = date.getDayOfYear();
//        if(date.getDayOfYear()==365){
//            System.out.print("Год невисокосный");
//        }else if(date.getDayOfYear()==366){
//            System.out.print("Год високосный");
//        }else{
//            System.out.print("хз, какой год");
//        }
        //5 задача
//        int month = 2;
//        int year = 2024;
//        System.out.print("Количество выходных: " + countWeekends(month, year));
        //задача 7
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите дату ");
//        String dateS = scanner.next();
//        LocalDate date = LocalDate.parse(dateS, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        System.out.print(date.plusDays(10));
        //задача 8
//        String utcTime = "2024-01-29T12:00:00";
//        String moscow = convertUtcToMoscow(utcTime);
//        System.out.println("Московское время: " + moscow);
        //задача 9
//        LocalDate date = LocalDate.of(2007, 1, 1);
//        LocalDate today = LocalDate.now();
//        int n = today.getYear() - date.getYear();
//        System.out.println(n);
        //задача 10
//        int month = 3;
//        int year = 2025;
//        MonthCalendar(month, year);
        //задача 12
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String eventDateTime = "2029-09-01 15:00:00";
//        LocalDateTime eventTime = LocalDateTime.parse(eventDateTime, formatter);
//        LocalDateTime now = LocalDateTime.now();
//        if (now.isAfter(eventTime)) {
//            System.out.println("Событие прошло");
//        } else {
//            Duration duration = Duration.between(now, eventTime);
//            long hours = duration.toHours();
//            long minutes = duration.toMinutesPart();
//            long seconds = duration.toSecondsPart();
//            System.out.println("осталось: " + hours + " часов " + minutes + " минут " + seconds + " секунд");
//        }
        // задача 13
//        LocalDateTime start = LocalDateTime.of(2025, 1, 30, 6, 0);
//        LocalDateTime end = LocalDateTime.of(2025, 3, 2, 18, 0);
//        long sum = 0;
//        LocalDateTime f = start;
//        while (!f.isAfter(end)) {
//            DayOfWeek dayOfWeek = f.getDayOfWeek();
//            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
//                sum += 9;
//            }
//            f = f.plusDays(1).withHour(9).withMinute(0);
//        }
//        System.out.println("Количество рабочих часов: " + sum);
        //задача 14
//        LocalDate date = LocalDate.of(2024, 1, 29);
//        DateTimeFormatter formatterru = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("ru"));
//        DateTimeFormatter formatteren = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
//        System.out.println(date.format(formatterru));
//        System.out.println(date.format(formatteren));
        //задача 15
//        LocalDate date = LocalDate.of(2025, 9, 8);
//        DayOfWeek dayOfWeek = date.getDayOfWeek();
//        String[] days = {"", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
//        System.out.println("День недели: " + days[dayOfWeek.getValue()]);
    }
}