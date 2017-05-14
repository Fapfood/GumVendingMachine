import java.util.Collection;
import java.util.LinkedList;

class MoneyController {
    private Coin coinBuffer;
    private final Collection<Coin> bank;

    MoneyController() {
        this.coinBuffer = null;
        this.bank = new LinkedList<>();
    }

    void insertCoin(Coin coin) {
        if (!this.isCoinInserted())
            this.coinBuffer = coin;
        else
            throw new VendingMachineException("W automacie jest już moneta");
    }

    Coin returnCoin() {
        if (this.isCoinInserted()) {
            Coin returnedCoin = this.coinBuffer;
            this.coinBuffer = null;
            return returnedCoin;
        } else
            throw new VendingMachineException("W automacie nie ma monety");
    }

    void storeCoin() {
        if (this.isCoinInserted()) {
            bank.add(this.coinBuffer);
            this.coinBuffer = null;
        } else
            throw new VendingMachineException("W automacie nie ma monety");
    }

    Collection<Coin> removeCoins() {
        Collection<Coin> coins = new LinkedList<>(this.bank);
        this.bank.removeAll(coins);
        return coins;
    }

    boolean isCoinInserted() {
        return coinBuffer != null;
    }
}
