package entity.powerup;

import entity.player.Player;

import management.ForexManager;

public class ForexPowerUpBehaviour implements PowerUpBehaviour{
    ForexManager fm = ForexManager.getInstance();

    @Override
    public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target, Player p) {
        fm.updateExRates(target, amount);
    }
}
