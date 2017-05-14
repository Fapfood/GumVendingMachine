import java.util.Collection;
import java.util.List;

public class VendingMachine {
    private final GumContainer gumContainer;
    private final MoneyController moneyController;
    private Gumball gumProvider;

    public VendingMachine(int capacity) {
        this.gumContainer = new GumContainer(capacity);
        this.moneyController = new MoneyController();
        this.gumProvider = null;
    }

    public void insertCoin(Coin coin) {
        this.moneyController.insertCoin(coin);
    }

    public void confirmTransaction() {
        if (this.moneyController.isCoinInserted()) {
            if (this.isProviderEmpty()) {
                this.gumProvider = this.gumContainer.provideGum();
                this.moneyController.storeCoin();
            } else
                throw new VendingMachineException("Nie można wcisnąć przycisku, bo w pojemniczku jest poprzednia guma");
        } else
            throw new VendingMachineException("W automacie nie ma monety");
    }

    public Gumball getGum() {
        if (!this.isProviderEmpty()) {
            Gumball gumball = this.gumProvider;
            this.gumProvider = null;
            return gumball;
        } else
            throw new VendingMachineException("Nie ma gumy w pojemniczku");
    }

    public Coin returnCoin() {
        return this.moneyController.returnCoin();
    }

    public void replenishGums(List<Gumball> gumballs) {
        this.gumContainer.replenishGums(gumballs);
    }

    public Collection<Coin> removeCoins() {
        return this.moneyController.removeCoins();
    }

    private boolean isProviderEmpty() {
        return gumProvider == null;
    }
}
