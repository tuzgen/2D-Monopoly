package entity.powerup;

import entity.player.Player;

import management.ForexManager;

import java.io.Serializable;

public class ForexPowerUpBehaviour implements PowerUpBehaviour, Serializable {
    ForexManager fm = ForexManager.getInstance();

    @Override
    public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target, Player p, PowerUp powerUp) {
        fm.updateExRates(target, amount);
        p.removePowerUp(powerUp);
    }
}
