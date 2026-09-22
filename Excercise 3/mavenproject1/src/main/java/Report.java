
import java.util.Arrays;
import java.util.Scanner;
import static java.util.Arrays.sort;

public class Report {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Names of the three water quality indicators.
        String[] indicators = {"Do", "pH", "Temperature"};

        // Read the analysis mode.
        int mode = scanner.nextInt();

        // Consume the remaining newline.
        scanner.nextLine();

        // This array will store all scores for the three indicators.
        int[][] allScores = null;

        // Read one line of scores for each indicator.
        for (int i = 0; i < indicators.length; i++) {

            // Split the input line into individual values.
            String[] values = scanner.nextLine().trim().split("\\s+");

            // Create the 2D array after reading the first line.
            if (allScores == null) {
                allScores = new int[indicators.length][values.length];
            }

            // Convert the values from Strings to integers.
            for (int j = 0; j < values.length; j++) {
                allScores[i][j] = Integer.parseInt(values[j]);
            }
        }

        scanner.close();

        System.out.println();

        // Create a Report object.
        Report report = new Report();

        // Generate a report for each indicator.
        for (int i = 0; i < indicators.length; i++) {
            report.generateReport(indicators[i], allScores[i], mode);
        }
    }

    public double computeAverage(int[] scores) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum / scores.length;
    }

    public double computeMedian(int[] scores) {
        sort(scores);

        return (scores[1] + scores[2]) / 2;
    }

    public int findHighestScore(int[] scores) {
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public String letterGrade(int[] scores) {
        double avg = computeAverage(scores);
        if (avg <= 59) {
            return "D";
        } else {
            if (avg <= 69) {
                return "P";
            }
            if (avg <= 79) {
                return "A";
            }
            if (avg <= 89) {
                return "E";
            }
            if (avg <= 100) {
                return "O";
            }
        }
        return "";
    }

    public void generateReport(String indicator, int[] scores, int mode) {
        switch (mode) {
            default:
                double avg = computeAverage(scores);
                double median = computeMedian(scores);
                int max = findHighestScore(scores);
                String.format("%.2f", avg);
                String.format("%.2f", max);
                String.format("%.2f", median);
                System.out.println("Report for " + indicator);
                System.out.print("Scores: ");
                System.out.print("[");
                for (int i = 0; i < 4; i++) {
                    System.out.print(scores[i]);
                    if (i != 3) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
                System.out.println("Average: " + String.format("%.2f", avg));
                System.out.println("Median: " + median);
                System.out.println("Highest: " + max);
                System.out.println("Letter grade: " + letterGrade(scores));
                break;

            case 1:
                System.out.println();
                avg = computeAverage(scores);
                String.format("%.2f", avg);
                System.out.println("Report for " + indicator);
                System.out.print("Scores: ");
                System.out.print("[");
                for (int i = 0; i < 4; i++) {
                    System.out.print(scores[i]);
                    if (i != 3) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
                System.out.println("Average: " + avg);
                break;

            case 2:
                System.out.println();
                median = computeMedian(scores);
                String.format("%.2f", median);
                System.out.println("Report for " + indicator);
                System.out.print("Scores: ");
                System.out.print("[");
                for (int i = 0; i < 4; i++) {
                    System.out.print(scores[i]);
                    if (i != 3) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
                System.out.println("Median: " + median);

                break;
            case 3:
                System.out.println();
                max = findHighestScore(scores);
                String.format("%.2f", max);
                System.out.println("Report for " + indicator);
                System.out.print("Scores: ");
                System.out.print("[");
                for (int i = 0; i < 4; i++) {
                    System.out.print(scores[i]);
                    if (i != 3) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
                System.out.println("Highest: " + max);
                break;

            case 4:
                System.out.println("Report for " + indicator);
                System.out.print("Scores: ");
                System.out.print("[");
                for (int i = 0; i < 4; i++) {
                    System.out.print(scores[i]);
                    if (i != 3) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
                System.out.println("Letter grade: " + letterGrade(scores));
                break;
        }
    }

    String finalMessage = "";

    public String isImproving(int[] scores) {
        int lastElement = scores[scores.length - 1];
        int secondToLastElement = scores[scores.length - 1];
        if (scores.length == 0) {
            return finalMessage;
        }
        if (lastElement < secondToLastElement) {
            if (finalMessage == "increasing") {
                return "mixed";
            }
            finalMessage = "decreasing";
        } else {
            if (finalMessage == "decreasing") {
                return "mixed";
            }
            finalMessage = "increasing";
        }

        return isImproving(Arrays.copyOf(scores, scores.length - 1));
    }
}
