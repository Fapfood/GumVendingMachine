import java.util.LinkedList;
import java.util.List;

class GumContainer {
    private final int capacity;
    private final List<Gumball> actualContent;

    GumContainer(int capacity) {
        this.capacity = capacity;
        this.actualContent = new LinkedList<>();
    }

    Gumball provideGum() {
        if (!this.isEmpty())
            return actualContent.remove(0);
        else
            throw new VendingMachineException("Nie można dostarczyć gumy, bo zbiornik jest pusty");
    }

    void replenish(List<Gumball> gumballs) {
        while (!gumballs.isEmpty()) {
            Gumball gumball = gumballs.get(0);
            if (!this.replenishOne(gumball)) //is full now
                throw new VendingMachineException("Nie można dołożyć kolejnej gumy, bo zbiornik jest pełen");
            else
                gumballs.remove(0);
        }
    }

    private boolean replenishOne(Gumball gumball) {
        if (!this.isFull()) {
            actualContent.add(gumball);
            return true;
        } else
            return false;
    }

    private boolean isEmpty() {
        return actualContent.isEmpty();
    }

    private boolean isFull() {
        return actualContent.size() == capacity;
    }
}
