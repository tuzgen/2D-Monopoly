package entity.powerup;

import entity.Bank;
import entity.player.Player;
import management.GameManager;

import java.io.Serializable;

public class EarningPowerUpBehaviour implements PowerUpBehaviour, Serializable {

    @Override
    public void activate(String target, Player p, PowerUp powerUp) {
        if(!p.getIsEarningMore()) {
            p.setIsEarningMore(true);
            p.setEarningLifeTime(powerUp.getLifetime() + GameManager.getInstance().getRoundNo());
            p.getAccount().setPoweupRate(powerUp.getAmount());
            p.removePowerUp(powerUp);
        }
    }
}
