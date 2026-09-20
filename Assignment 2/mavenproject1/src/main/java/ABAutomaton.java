
import java.util.Scanner;

/**
 * Automatons A and B.
 *
 * TODO 1: Fill in your names and student IDs:
 *
 * @author Georgi Yordanov
 * @id 2498073
 * @author Nikola Shtinkov
 * @id 2509318
 */
class ABAutomaton {

    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gen.length; i++) {
            char current = gen[i] ? '*' : ' ';
            sb.append(current);
        }
        return sb.toString();
    }

    boolean[] nextGenA(boolean[] gen) {
        boolean[] newGen = new boolean[gen.length];
        for (int i = 0; i < gen.length; i++) {
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

            // Occupied cells remain occupied only if exactly one of their neighbors is occupied.
            // Empty cells remain empty only if both neighbors are empty.
            if (gen[i]) {
                if ((isRightOccupied && !isLeftOccupied) || (!isRightOccupied && isLeftOccupied)) {
                    newGen[i] = true;
                }
            } else {
                if (isLeftOccupied || isRightOccupied) {
                    newGen[i] = true;
                }
            }
        }
        return newGen;
    }

    boolean[] nextGenB(boolean[] gen) {
        boolean[] newGen = new boolean[gen.length];
        for (int i = 0; i < gen.length; i++) {
            int leftPos = Math.clamp(i - 1, 0, gen.length - 1);
            int rightPos = Math.clamp(i + 1, 0, gen.length - 1);

            boolean isLeftOccupied = gen[leftPos];
            boolean isRightOccupied = gen[rightPos];

            if (i == leftPos) {
                isLeftOccupied = false;
            } else if (i == rightPos) {
                isRightOccupied = false;
            }

            if (gen[i]) {
                if (!isRightOccupied) {
                    newGen[i] = true;
                }
            } else {
                if ((isRightOccupied && !isLeftOccupied) || (!isRightOccupied && isLeftOccupied)) {
                    newGen[i] = true;
                }
            }
        }
        return newGen;
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

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}
