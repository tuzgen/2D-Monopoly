package entity.powerup;

import entity.player.Player;
import management.GameManager;

import java.io.Serializable;
import java.util.ArrayList;

public class SlowDownPowerUpBehaviour implements PowerUpBehaviour, Serializable {

    @Override
    public void activate(String target, Player p, PowerUp powerUp) {

        ArrayList<Player> otherPlayers = new ArrayList<Player>();
        int yourIndex = GameManager.getInstance().getTurnOfPlayerIndex();

        for(int i = 0; i < 4; i++)
            if( i != yourIndex)
                otherPlayers.add(GameManager.getInstance().getPlayerAt(i));

        Player targetPlayer = null;
        for(int i = 0; i < 3; i++) {
            if (otherPlayers.get(i).getName().equals(target))
                targetPlayer = otherPlayers.get(i);
        }

        if(!targetPlayer.getIsSlowedDown()){
            targetPlayer.setIsSlowedDown(true);
            targetPlayer.setSlowDownLifetime(powerUp.getLifetime());
            targetPlayer.setSpeed(p.getSpeed()*powerUp.getAmount());
            System.out.println(p.getPowerUps());
            p.removePowerUp(powerUp);
            System.out.println(p.getPowerUps());
        }
    }



}
