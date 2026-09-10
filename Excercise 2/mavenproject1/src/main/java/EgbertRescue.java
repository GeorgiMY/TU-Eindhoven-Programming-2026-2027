
import java.util.Scanner;

public class EgbertRescue {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        String initMessage = "";
        for (int i = 0; i < n; i++) {
            int newChar = scanner.nextInt();

            initMessage = initMessage.concat("" + (char) newChar);
        }

        System.out.println(initMessage);

        int arrayLength = Math.ceilDiv(n, k);

        String[] brokenDownMessages = new String[arrayLength];
        String[] reversedBrokenDownMessages = new String[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            brokenDownMessages[i] = initMessage.substring(k * i, Math.clamp(k * (i + 1), 0, n));
        }

        for (int i = 0; i < arrayLength; i++) {
            String reversedMessage = "";
            for (int j = 0; j < brokenDownMessages[i].length(); j++) {
                reversedMessage = reversedMessage.concat("" + brokenDownMessages[i].charAt(brokenDownMessages[i].length() - 1 - j));
            }
            reversedBrokenDownMessages[i] = reversedMessage;
        }

        String reversedMessage = "";
        for (int i = 0; i < arrayLength; i++) {
            reversedMessage = reversedMessage.concat(reversedBrokenDownMessages[i]);
        }

        System.out.println(reversedMessage);

        for (int i = 0; i < reversedMessage.length(); i++) {
            if (reversedMessage.charAt(i) == '*') {
                reversedMessage = reversedMessage.substring(0, i - 1) + reversedMessage.substring(Math.clamp(i + 1, 0, reversedMessage.length() - 1), reversedMessage.length());
            }
        }

        String purgedMessage = reversedMessage;

        System.out.println(purgedMessage);

        String finalMessage = "";

        for (int i = 0; i < purgedMessage.length(); i++) {
            finalMessage = finalMessage.concat("" + (char) ((int) purgedMessage.charAt(i) - i));
        }

        System.out.println(finalMessage);

        char[][] grid = new char[finalMessage.length() / k][k];

        for (int i = 0; i < finalMessage.length() / k; i++) {
            for (int j = 0; j < k; j++) {
                grid[i][j] = finalMessage.charAt(i * k + j);
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        String rescueCode = "";
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < finalMessage.length() / k; j++) {
                rescueCode = rescueCode.concat("" + grid[j][i]);
            }
        }

        System.out.println(rescueCode);
    }
}
