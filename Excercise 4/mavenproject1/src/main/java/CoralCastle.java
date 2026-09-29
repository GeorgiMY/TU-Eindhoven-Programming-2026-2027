
public class CoralCastle {

    private String name;
    private Cave[] caves;

    public CoralCastle(String name, int numberOfCaves) {
        this.name = name;
        this.caves = new Cave[numberOfCaves];

        for (int i = 0; i < this.caves.length; i++) {
            int number = 101 + i;
            int capacity = (i % 4) + 2;
            this.caves[i] = new Cave(number, capacity);
        }
    }

    public Cave checkIn(String guestName, int guestSize) {
        Guest guest = new Guest(guestName, guestSize);

        for (Cave cave : this.caves) {
            if (guest.checkIn(cave)) {
                return cave;
            }
        }

        return null;
    }

    public boolean checkOut(String guestName) {
        Cave cave = getCaveByGuestName(guestName);

        if (cave == null) {
            return false;
        }

        return cave.getGuest().checkOut();
    }

    public Cave getCaveByGuestName(String guestName) {
        for (Cave cave : this.caves) {
            if (!cave.isFree() && cave.getGuest().getName().equals(guestName)) {
                return cave;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String result = "Castle " + this.name;

        for (Cave cave : this.caves) {
            result += "\n" + cave;
        }

        return result;
    }

}
