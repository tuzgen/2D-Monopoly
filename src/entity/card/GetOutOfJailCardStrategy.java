package entity.card;

import entity.player.Player;

import java.io.Serializable;

public class GetOutOfJailCardStrategy implements CardStrategy, Serializable {
    @Override
    public void activateCard(Player player, Card card) {
        player.setIsArrested(false);
    }
}
