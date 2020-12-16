package entity.card;

import entity.player.Player;

public class MovementByNumCardStrategy implements CardStrategy{
    @Override
    public void activateCard(Player player, Card card) {
        int amount = card.getAmount();
        //TODO
    }
}
