package franek;

import java.util.ArrayList;

public class MoneyController {
    private Coin coinBuffer;
    private ArrayList<Coin> bank;

    protected Coin returnCoin() {
        Coin returnedCoin = this.coinBuffer;
        this.coinBuffer = NULL;
        return returnedCoin;
    }

    protected boolean isCoinInserted() {
        if(coinBuffer == NULL)
            return false;
        return true;
    }

    protected void insertCoinToBuffer(Coin coin){
        this.coinBuffer = coin;
    }

    protected void storeCoinToBank() {
        Coin bankedCoin = this.coinBuffer;
        this.coinBuffer = NULL;
        bank.add(coin);
    }
}
