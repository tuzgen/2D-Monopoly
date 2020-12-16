package entity.card;

import entity.player.Player;

public class MovementToCardStrategy implements CardStrategy{

    @Override
    public void activateCard(Player player, Card card) {
        int tileNo = card.getAmount();
        //TODO
    }
}
