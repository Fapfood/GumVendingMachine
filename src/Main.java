import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println(">>> new VendingMachine(3)");
        VendingMachine vendingMachine = new VendingMachine(3);


        System.out.println(">>> getGum");
        try {
            vendingMachine.getGum();
        } catch (VendingMachineException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println(">>> returnCoin");
        try {
            vendingMachine.returnCoin();
        } catch (VendingMachineException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println(">>> confirmTransaction");
        try {
            vendingMachine.confirmTransaction();
        } catch (VendingMachineException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println(">>> insertCoin");
        vendingMachine.insertCoin(new Coin());


        System.out.println(">>> confirmTransaction");
        try {
            vendingMachine.confirmTransaction();
        } catch (VendingMachineException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println(">>> insertCoin");
        try {
            vendingMachine.insertCoin(new Coin());
        } catch (VendingMachineException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println(">>> returnCoin");
        System.out.println(vendingMachine.returnCoin());


        System.out.println(">>> replenishGums");
        LinkedList<Gumball> gumballs = new LinkedList<>();
        gumballs.add(new Gumball());
        System.out.println(gumballs);

        vendingMachine.replenishGums(gumballs);
        System.out.println(gumballs);


        System.out.println(">>> replenishGums");
        for (int i = 0; i < 4; i++)
            gumballs.add(new Gumball());
        System.out.println(gumballs);

        try {
            vendingMachine.replenishGums(gumballs);
        } catch (VendingMachineException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(gumballs);


        System.out.println(">>> insertCoin");
        vendingMachine.insertCoin(new Coin());


        System.out.println(">>> removeCoins");
        System.out.println(vendingMachine.removeCoins());


        System.out.println(">>> confirmTransaction");
        vendingMachine.confirmTransaction();


        System.out.println(">>> insertCoin");
        vendingMachine.insertCoin(new Coin());


        System.out.println(">>> confirmTransaction");
        try {
            vendingMachine.confirmTransaction();
        } catch (VendingMachineException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println(">>> getGum");
        System.out.println(vendingMachine.getGum());


        System.out.println(">>> removeCoins");
        System.out.println(vendingMachine.removeCoins());
    }
}
