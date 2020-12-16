package entity.powerup;

import entity.player.Player;

public class SlowDownPowerUpBehaviour implements PowerUpBehaviour{

    @Override
    public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target, Player p) {
       p.setSpeed(p.getSpeed()*amount);
    }
}
