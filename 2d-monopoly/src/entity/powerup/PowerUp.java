package entity.powerup;

import java.util.concurrent.ThreadLocalRandom;

public class PowerUp {
    private int lifetime;
    private PowerUpBehaviour behaviour;
    private double amount;
    private String target;

    public PowerUp(PowerUpBehaviour behaviour){
        this.behaviour = behaviour;
        lifetime = ThreadLocalRandom.current().nextInt(2, 6);
        if(behaviour.getClass().getName() == "ForexPowerUpBehaviour"){
            amount = ThreadLocalRandom.current().nextInt(3, 36);
            int[] signs = {-1, 1};
            amount *= signs[ThreadLocalRandom.current().nextInt(0, 2)];
        }
        if(behaviour.getClass().getName() == "EarningPowerUpBehaviour"){
            amount = ThreadLocalRandom.current().nextDouble(1.1, 6.0);

        }
        if(behaviour.getClass().getName() == "StrikePowerUpBehaviour"){
            amount = ThreadLocalRandom.current().nextInt(2, 13);
        }
        if(behaviour.getClass().getName() == "SlowDownPowerUpBehaviour"){
            amount = ThreadLocalRandom.current().nextDouble((1/3), (5/6));
        }
        target = "";
    }

    public void activate(){
        behaviour.activate(lifetime, behaviour, amount, target);
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
