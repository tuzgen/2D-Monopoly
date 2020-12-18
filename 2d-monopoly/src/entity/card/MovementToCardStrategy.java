package entity.card;

import entity.player.Player;

public class MovementToCardStrategy implements CardStrategy{

    @Override
    public void activateCard(Player player, Card card) {
        int tileNo = card.getAmount();
        player.setLocation(tileNo); // THIS NEED TO UPDATE THE MAP DO NOT FORGET YOU MAY ADD IT TO THE CHARACTER CLASS
    }
}
