package entity.powerup;

public interface PowerUpBehaviour {
    public void activate(int lifetime, PowerUpBehaviour behaviour, double amount, String target);
}
