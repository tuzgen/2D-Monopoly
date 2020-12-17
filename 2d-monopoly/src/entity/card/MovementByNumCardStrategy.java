package entity.card;

import entity.player.Player;

public class MovementByNumCardStrategy implements CardStrategy{
    @Override
    public void activateCard(Player player, Card card) {
        int amount = card.getAmount();
        int currentTileNo = player.getLocation();
        player.setLocation(currentTileNo + amount);// THIS NEED TO UPDATE THE MAP DO NOT FORGET YOU MAY ADD IT TO THE CHARACTER CLASS
    }
}
