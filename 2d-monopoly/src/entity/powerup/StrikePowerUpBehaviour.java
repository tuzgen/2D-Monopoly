package entity.powerup;

import entity.player.Player;
import management.GameManager;

import java.io.Serializable;
import java.util.ArrayList;

public class StrikePowerUpBehaviour implements PowerUpBehaviour, Serializable {
     @Override
     public void activate(String target, Player p, PowerUp powerUp) {
          ArrayList<Player> otherPlayers = new ArrayList<Player>();
          int yourIndex = GameManager.getInstance().getTurnOfPlayerIndex();

          for(int i = 0; i < 4; i++)
               if( i != yourIndex)
                    otherPlayers.add(GameManager.getInstance().getPlayerAt(i));

          Player targetPlayer = null;
          for(int i = 0; i < 3; i++)
               if(otherPlayers.get(i).getName().equals(target))
                    targetPlayer = otherPlayers.get(i);

          targetPlayer.setLocation(p.getLocation() - (int) powerUp.getAmount());
          p.removePowerUp(powerUp);
     }
}
