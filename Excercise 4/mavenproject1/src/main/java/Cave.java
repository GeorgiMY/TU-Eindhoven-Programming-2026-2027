
public class Cave {
    private int number;
    private int capacity;
    private Guest guest;

    public Cave(int number, int capacity) {
        setNumber(number);
        setCapacity(capacity);
    }

    public int getNumber() {
        return this.number;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Guest getGuest() {
        return this.guest;
    }

    public boolean isFree() {
        return this.guest == null;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    
    private void setNumber(int number) {
        this.number = number;
    }
    
    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        if (isFree()) {
            return "Cave[" + this.number + ", capacity=" + this.capacity + ", free]";
        }
        
        return "Cave[" + this.number + ", capacity=" + this.capacity + ", guest=" + this.guest + "]";
    }

}
