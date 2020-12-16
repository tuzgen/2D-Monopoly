package entity.card;

import entity.player.Player;

public class GetOutOfJailCardStrategy implements CardStrategy{
    @Override
    public void activateCard(Player player, Card card) {
        player.setIsArrested(false);
    }
}
