package entity.powerup;

import management.ForexManager;

public class ForexPowerUpBehaviour implements PowerUpBehaviour{
    ForexManager fm = ForexManager.getInstance();

    @Override
    public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target) {
        fm.updateExRates(target, amount);
    }
}
