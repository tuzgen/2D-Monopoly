package entity.powerup;

import entity.player.Player;

import management.ForexManager;

import java.io.Serializable;

public class ForexPowerUpBehaviour implements PowerUpBehaviour, Serializable {
    ForexManager fm = ForexManager.getInstance();

    @Override
    public void activate(String target, Player p, PowerUp powerUp) {
        fm.updateExRates(target, powerUp.getAmount());
        p.removePowerUp(powerUp);
    }
}
