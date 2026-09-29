
import java.util.Scanner;

public class CastleTUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String castleName = scanner.nextLine();
        int numberOfCaves = scanner.nextInt();

        CoralCastle castle = new CoralCastle(castleName, numberOfCaves);
        System.out.println("Castle " + castleName + " created with " + numberOfCaves + " caves. Type 'help' for commands.");

        boolean running = true;

        while (running && scanner.hasNext()) {
            String command = scanner.next();

            switch (command) {
                case "in": {
                    String guestName = scanner.next();
                    int guestSize = scanner.nextInt();
                    Cave cave = castle.checkIn(guestName, guestSize);

                    if (cave != null) {
                        System.out.println("Guest " + guestName + " gets cave " + cave.getNumber() + ".");
                    } else {
                        System.out.println("No suitable cave available for " + guestName + ".");
                    }
                    break;
                }

                case "out": {
                    String guestName = scanner.next();

                    if (castle.checkOut(guestName)) {
                        System.out.println(guestName + " has checked out.");
                    } else {
                        System.out.println("Guest " + guestName + " is not in the castle.");
                    }
                    break;
                }

                case "cave": {
                    String guestName = scanner.next();
                    Cave cave = castle.getCaveByGuestName(guestName);

                    if (cave != null) {
                        System.out.println("Guest " + guestName + " is in cave " + cave.getNumber() + ".");
                    } else {
                        System.out.println("Guest " + guestName + " doesn't have a cave.");
                    }
                    break;
                }

                case "print":
                    System.out.println(castle);
                    break;

                case "help":
                    System.out.println("Commands:");
                    System.out.println("in [name] [size] - Check in a guest with the given name and size");
                    System.out.println("out [name] - Check out the guest with the given name");
                    System.out.println("cave [name] - Show the cave number of the guest with the name");
                    System.out.println("print - Print the current state of the castle");
                    System.out.println("help - Show this help menu");
                    System.out.println("exit - Exit the program");
                    break;

                case "exit":
                    System.out.println("Closing the system.");
                    running = false;
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }
}
