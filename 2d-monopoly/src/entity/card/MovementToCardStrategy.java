package entity.card;

import entity.player.Player;
import gui.menus.controller.GameMenuController;

import java.io.Serializable;

public class MovementToCardStrategy implements CardStrategy, Serializable {

    @Override
    public void activateCard(Player player, Card card) {
        int tileNo = card.getAmount();
        player.setLocation(tileNo); // THIS NEED TO UPDATE THE MAP DO NOT FORGET YOU MAY ADD IT TO THE CHARACTER CLASS

    }
}
