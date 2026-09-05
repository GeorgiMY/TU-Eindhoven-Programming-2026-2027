
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NextDateCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        boolean isLeap = ((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0;

        Map<Integer, Integer> dictionary = new HashMap<>();

        dictionary.put(1, 31);
        dictionary.put(2, (isLeap ? 29 : 28));
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

        if (day == dictionary.get(month)) {
            day = 1;
            month += 1;
        } else {
            day += 1;
        }

        if (month == 13) {
            month = 1;
            year += 1;
        }

        System.out.print("It is " + day + "/" + month + "/" + year + " tomorrow!");
    }
}
