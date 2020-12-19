package entity.powerup;

import entity.player.Player;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class PowerUp implements Serializable {
    private int lifetime;
    private PowerUpBehaviour behaviour;
    private double amount;
    private String target;

    public PowerUp(PowerUpBehaviour behaviour){
        this.behaviour = behaviour;
        lifetime = ThreadLocalRandom.current().nextInt(2, 6);
        if(behaviour.getClass() == ForexPowerUpBehaviour.class){
            amount = ThreadLocalRandom.current().nextInt(3, 36);
            int[] signs = {-1, 1};
            amount *= signs[ThreadLocalRandom.current().nextInt(0, 2)];
        }
        if(behaviour.getClass() == EarningPowerUpBehaviour.class){
            amount = ThreadLocalRandom.current().nextDouble(1.1, 6.0);

        }
        if(behaviour.getClass() == StrikePowerUpBehaviour.class){
            amount = ThreadLocalRandom.current().nextInt(2, 13);
        }
        if(behaviour.getClass() == SlowDownPowerUpBehaviour.class){
            amount = ThreadLocalRandom.current().nextDouble(0.333, 0.833);
        }
        target = "";
    }

    public void activate(Player p){
        behaviour.activate(lifetime, behaviour, amount, target, p);
    }
    //get and set methods
    public int getLifetime() {
        return lifetime;
    }
    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
