
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BetweenDateCalculator {

    public static void main(String[] args) {
        Scanner scannerFirst = new Scanner(System.in);

        int dayFirst = scannerFirst.nextInt();
        int monthFirst = scannerFirst.nextInt();
        int yearFirst = scannerFirst.nextInt();
        boolean isLeapFirst = ((yearFirst % 4 == 0) && (yearFirst % 100 != 0)) || yearFirst % 400 == 0;

        Scanner scannerSecond = new Scanner(System.in);

        int daySecond = scannerSecond.nextInt();
        int monthSecond = scannerSecond.nextInt();
        int yearSecond = scannerSecond.nextInt();
        boolean isLeapSecond = ((yearSecond % 4 == 0) && (yearSecond % 100 != 0)) || yearSecond % 400 == 0;

        Map<Integer, Integer> dictionary = new HashMap<>();

        dictionary.put(1, 31);
        dictionary.put(2, (isLeapFirst ? 29 : 28));
        dictionary.put(22, (isLeapSecond ? 29 : 28));
        dictionary.put(3, 31);
        dictionary.put(4, 30);
        dictionary.put(5, 31);
        dictionary.put(6, 30);
        dictionary.put(7, 31);
        dictionary.put(8, 31);
        dictionary.put(9, 30);
        dictionary.put(10, 31);
        dictionary.put(11, 30);
        dictionary.put(12, 31);

        int finalYear = yearSecond - yearFirst;
        int finalMonth = Math.abs(monthSecond - monthFirst);
        int finalDay = dictionary.get(finalMonth) - Math.abs(daySecond - dayFirst);
    }

}
