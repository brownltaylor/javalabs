package robbers;

public class LootBag {

    private double cash;

    public LootBag(double cash){
        this.cash = cash;
    }

    public void addCash(double score){
        cash += score;
    }

    public double getCash(){
        return cash;
    }
}
