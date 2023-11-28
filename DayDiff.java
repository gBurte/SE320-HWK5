import java.util.Scanner;

public class DayDiff {
    private int year;
    private int month;
    private int day;

    public DayDiff(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static int daysBetween(DayDiff startDate, DayDiff endDate) {
        int startJulian = toJulian(startDate.getYear(), startDate.getMonth(), startDate.getDay());
        int endJulian = toJulian(endDate.getYear(), endDate.getMonth(), endDate.getDay());

        return endJulian - startJulian;
    }

    private static int toJulian(int year, int month, int day) {
        int jy = year;
        if (year < 0) jy++;
        int jm = month;
        if (month > 2) jm++;
        else {
            jy--;
            jm += 13;
        }
        int jul = (int) (365.25 * jy + 30.6001 * jm + day + 1720995.0);

        int IGREG = 15 + 31 * (10 + 12 * 1582);

        if (day + 31 * (month + 12 * year) >= IGREG) {
            int ja = (int) (0.01 * jy);
            jul += 2 - ja + (int) (0.25 * ja);
        }

        return jul;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2001 August 25th
        DayDiff birthdate = new DayDiff(2001, 8, 25);


        System.out.print("Please, Enter the current year: ");
        int currentYear = scanner.nextInt();

        System.out.print("Please, Enter the current month: ");
        int currentMonth = scanner.nextInt();

        System.out.print("PLease, Enter the current day: ");
        int currentDay = scanner.nextInt();

        DayDiff currentDate = new DayDiff(currentYear, currentMonth, currentDay);

        // Calculate the number of days between the two dates
        int daysElapsed = DayDiff.daysBetween(birthdate, currentDate);

        // Print the number of days
        System.out.println("Number of days since birth: " + daysElapsed);
    }
}
