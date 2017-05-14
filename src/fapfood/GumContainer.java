package fapfood;

import java.util.LinkedList;
import java.util.List;

public class GumContainer {
    private int capacity;
    private List<Gumball> actualContent;

    public GumContainer(int capacity) {
        this.capacity = capacity;
        this.actualContent = new LinkedList<>();
    }

    public Gumball provideGum() {
        if (!this.isEmpty())
            return actualContent.remove(0);
        else
            throw new VendingMachineException("Nie można dostarczyć gumy, bo zbiornik jest pusty");
    }

    public void replenish(List<Gumball> gumballs) {
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
