package entity.powerup;

import entity.player.Player;

import java.util.ArrayList;

public class StrikePowerUpBehaviour implements PowerUpBehaviour{
     @Override
     public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target, Player p) {
          p.setLocation(p.getLocation() - (int)amount);
     }
}
