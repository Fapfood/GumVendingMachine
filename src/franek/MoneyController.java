package franek;

import java.util.ArrayList;

public class MoneyController {
    private Coin coinBuffer;
    private ArrayList<Coin> bank;

    public Coin returnCoin() {
        if(this.isCoinInserted()) {
            Coin returnedCoin = this.coinBuffer;
            this.coinBuffer = NULL;
            return returnedCoin;
        }
        else
            throw(new VendingMachineException("There is no coin in buffer!"));
    }

    private boolean isCoinInserted() {
        if(coinBuffer == NULL)
            return false;
        return true;
    }

    public void insertCoinToBuffer(Coin coin){
        if(this.isCoinInserted())
            throw(new VendingMachineException("Buffer is full!"));
        else
            this.coinBuffer = coin;
    }

    public void storeCoinToBank() {
        Coin bankedCoin = this.coinBuffer;
        this.coinBuffer = NULL;
        bank.add(coin);
    }
}
