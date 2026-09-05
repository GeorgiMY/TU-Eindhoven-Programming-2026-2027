
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class DateValidator {

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

        String invalidDate = day + "/" + month + "/" + year + " is not a valid date!";

        if (day > 31 || day <= 0) {
            System.out.print(invalidDate);
            return;
        }
        if (month > 12 || month <= 0) {
            System.out.print(invalidDate);
            return;
        }
        if (year < 1) {
            System.out.print(invalidDate);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : dictionary.entrySet()) {
            if (entry.getKey() == month) {
                if (entry.getValue() < day) {
                    System.out.print(invalidDate);
                    return;
                }
            }
        }

        System.out.print(day + "/" + month + "/" + year + " is a valid date!");
    }
}
