package entity.card;

import entity.player.Player;
import gui.menus.controller.GameMenuController;

import java.io.Serializable;

public class MovementByNumCardStrategy implements CardStrategy, Serializable {
    @Override
    public void activateCard(Player player, Card card) {
        int amount = card.getAmount();
        int currentTileNo = player.getLocation();
        player.setLocation((40 + currentTileNo + amount) % 40);
    // THIS NEED TO UPDATE THE MAP DO NOT FORGET YOU MAY ADD IT TO THE CHARACTER CLASS
    }
}
