package entity.powerup;

import entity.Bank;
import entity.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PowerUpCrate implements Serializable {
    private final double PRICE = 50000;
    private ArrayList<PowerUp> powerUps;
    private Player player;
    private Bank bank;

    public PowerUpCrate(Player p){
        powerUps = new ArrayList<PowerUp>();
        player = p;
        powerUps.add(new PowerUp(new ForexPowerUpBehaviour()));
        powerUps.add(new PowerUp(new EarningPowerUpBehaviour()));
        powerUps.add(new PowerUp(new SlowDownPowerUpBehaviour()));
        powerUps.add(new PowerUp(new StrikePowerUpBehaviour()));
    }

    public boolean buyPowerUp(){
        if(bank.getInstance().takeMoney(player, PRICE)){
            PowerUp pu = openPowerUpCrate();
            player.addPowerUp(pu);
            return true;
        }
        return false;
    }

    private PowerUp openPowerUpCrate(){
        int powerUpDecider = ThreadLocalRandom.current().nextInt(0, 5);
        return powerUps.get(powerUpDecider);
    }

    public double getPrice() {
        return PRICE;
    }
}
