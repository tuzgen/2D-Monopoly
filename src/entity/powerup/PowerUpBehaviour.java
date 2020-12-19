package entity.powerup;
import entity.player.Player;
public interface PowerUpBehaviour {
    public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target, Player p);
}
