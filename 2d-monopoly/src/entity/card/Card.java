package entity.card;

import entity.Bank;
import entity.player.Player;

public class Card {
    private String feature;
    private CardStrategy cardStrategy;
    private int amount;
    private Bank bank;

    // Constructor
    public Card(CardStrategy cardStrategy, String feature, int amount){
        this.cardStrategy = cardStrategy;
        this.feature = feature;
        this.amount = amount;
        bank = Bank.getInstance();
    }

    public void activateCard(Player player){
        cardStrategy.activateCard(player, this);
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

    public Bank getBank() {
        return bank;
    }

    public CardStrategy getCardStrategy() {
        return cardStrategy;
    }
}
