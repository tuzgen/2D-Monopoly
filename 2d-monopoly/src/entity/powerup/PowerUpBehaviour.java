package entity.powerup;
import entity.player.Player;
public interface PowerUpBehaviour {
    public void activate(String target, Player p, PowerUp powerUp);
}
