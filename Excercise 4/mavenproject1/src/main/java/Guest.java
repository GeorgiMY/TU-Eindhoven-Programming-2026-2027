
public class Guest {

    private String name;
    private int size;
    private Cave cave;

    public Guest(String name, int size) {
        setName(name);
        setSize(size);
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public boolean checkIn(Cave newCave) {
        if (this.cave == null && newCave.isFree() && newCave.getCapacity() >= this.size) {
            this.cave = newCave;
            newCave.setGuest(this);
            return true;
        }

        return false;
    }

    public boolean checkOut() {
        if (this.cave == null) {
            return false;
        }

        Cave oldCave = this.cave;
        this.cave = null;
        oldCave.setGuest(null);
        return true;
    }

    @Override
    public String toString() {
        return "Guest[name=" + this.name + ", size=" + this.size + "]";
    }
}
