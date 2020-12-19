package entity.card;

import entity.player.Player;

import java.io.Serializable;

public interface CardStrategy {
    public void activateCard(Player player, Card card);
}
