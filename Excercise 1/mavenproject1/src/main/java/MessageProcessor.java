
import java.util.Scanner;

public class MessageProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        String message = scanner.next();

        switch (mode) {
            case 1:
                System.out.println("Hello, " + message + "!");
                break;
            case 2:
                if (message.contains("ss")) {
                    System.out.println("Contains double s");
                } else {
                    System.out.println("Does not contain double s");
                }
                break;
            case 3:
                if (message.length() % 2 == 0) {
                    System.out.println(message.substring(message.length() / 2 - 1, message.length() / 2 + 1));
                } else {
                    System.out.println(message.substring(message.length() / 2, message.length() / 2 + 1));
                }
                break;
            default:
                System.out.println("Unknown mode");
                break;
        }
    }
}
