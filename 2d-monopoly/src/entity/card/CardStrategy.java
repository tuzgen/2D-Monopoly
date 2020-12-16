package entity.card;

import entity.player.Player;

public interface CardStrategy {
    public void activateCard(Player player, Card card);
}
