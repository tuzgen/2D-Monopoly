package entity.card;

import entity.player.Player;

public class TransactionCardStrategy implements CardStrategy{
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
