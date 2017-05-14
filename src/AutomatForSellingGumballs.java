package arek;
import fapfood.*;
import franek.*;

public class AutomatForSellingGumballs extends MoneyController {
    private GumContainer gumProvider;
    private MoneyController moneyController;

    public AutomatForSellingGumballs(GumContainer gumProvider){
        this.gumProvider = gumProvider;
        this.moneyController = new MoneyController();
    }

    public void insertCoin(Coin coin) throws VendingMachineException{
        this.moneyController.insertCoinToBuffer(coin);
    }

    public Gumball confirmTransaction() throws VendingMachineException{
        this.moneyController.storeCoinToBank();
        return this.getGum();
    }

    private Gumball getGum() throws VendingMachineException{
        return this.gumProvider.provideGum();
    }
}
