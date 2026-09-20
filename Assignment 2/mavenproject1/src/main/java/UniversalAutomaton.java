
import java.util.Scanner;

/**
 * Universal Automaton.
 *
 * TODO: Fill in your names and student IDs
 *
 * @author Georgi Yordanov
 * @id 2498073
 * @author Nikola Shtinkov
 * @id 2509318
 */
class UniversalAutomaton {

    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gen.length; i++) {
            char current = gen[i] ? '*' : ' ';
            sb.append(current);
        }
        return sb.toString();
    }

    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        boolean[] theNextGen = new boolean[gen.length];

        for (int i = 0; i < theNextGen.length; i++) {
            int leftPos = Math.clamp(i - 1, 0, gen.length - 1);
            int rightPos = Math.clamp(i + 1, 0, gen.length - 1);

            boolean isLeftOccupied = gen[leftPos];
            boolean isRightOccupied = gen[rightPos];

            if (i == leftPos) {
                isLeftOccupied = false;
            }

            if (i == rightPos) {
                isRightOccupied = false;
            }

            int rule = 0;
            if (gen[i]) {
                // 2, 3, 6, 7

                // 2
                if (!(isLeftOccupied && isRightOccupied)) {
                    rule = 2;
                }

                // 3
                if (!isLeftOccupied && isRightOccupied) {
                    rule = 3;
                }

                // 6
                if (isLeftOccupied && !isRightOccupied) {
                    rule = 6;
                }

                // 7
                if (isLeftOccupied && isRightOccupied) {
                    rule = 7;
                }
            } else {
                // 0, 1, 4, 5,

                // 0
                if (!(isLeftOccupied && isRightOccupied)) {
                    rule = 0;
                }

                // 1
                if (!isLeftOccupied && isRightOccupied) {
                    rule = 1;
                }

                // 4
                if (isLeftOccupied && !isRightOccupied) {
                    rule = 4;
                }

                // 5
                if (isLeftOccupied && isRightOccupied) {
                    rule = 5;
                }
            }

            theNextGen[i] = ruleSequence[rule];
        }

        return theNextGen;
    }

    boolean[] readInitalGeneration(int length) {
        boolean[] firstGen = new boolean[length];

        scanner.next();

        String token = scanner.next();

        while (!token.equals("init_end")) {
            int position = Integer.parseInt(token) - 1;

            if (position < length) {
                firstGen[position] = true;
            }

            token = scanner.next();
        }

        return firstGen;
    }

    boolean[] readRuleSequence() {
        boolean[] rulesList = new boolean[8];

        for (int i = 0; i < rulesList.length; i++) {
            rulesList[i] = scanner.nextInt() != 0;
        }

        return rulesList;
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}
