package entity.powerup;

import entity.player.Player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PowerUpCrate {
    private ArrayList<PowerUp> powerUps;
    private double price;

    public PowerUpCrate(Player p){
        powerUps.add(new PowerUp(new ForexPowerUpBehaviour()));
        powerUps.add(new PowerUp(new EarningPowerUpBehaviour()));
        powerUps.add(new PowerUp(new SlowDownPowerUpBehaviour()));
        powerUps.add(new PowerUp(new StrikePowerUpBehaviour()));
    }

    public PowerUp openPowerUpCrate(){
        int powerUpDecider = ThreadLocalRandom.current().nextInt(0, 5);
        return powerUps.get(powerUpDecider);
    }

    public double getPrice() {
        return price;
    }
}
