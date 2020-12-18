package entity.powerup;

import entity.player.Player;

import java.io.Serializable;

public class SlowDownPowerUpBehaviour implements PowerUpBehaviour, Serializable {

    @Override
    public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target, Player p) {
       p.setSpeed(p.getSpeed()*amount);
    }
}
