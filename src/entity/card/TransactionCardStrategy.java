package entity.card;

import entity.player.Player;

import java.io.Serializable;

public class TransactionCardStrategy implements CardStrategy, Serializable {
    @Override
    public void activateCard(Player player, Card card) {
        int paymentAmount = card.getAmount();
        if(paymentAmount < 0){
            card.getBank().takeMoney(player, paymentAmount * (-1));
        } else {
            card.getBank().giveMoney(player,paymentAmount);
        }
    }
}
