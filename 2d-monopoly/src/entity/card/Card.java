package entity.card;

public class Card {
    private String feature;
    private CardStrategy cardStrategy;
    private int amount;

    //Constructor
    public Card(CardStrategy cardStrategy, String feature, int amount){
        this.cardStrategy = cardStrategy;
        this.feature = feature;
        this.amount = amount;
    }

    public void activateCard(){
        //TODO
    }

    // get-set Methods
    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
