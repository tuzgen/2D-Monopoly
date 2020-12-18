package entity.player.npcs;

import entity.player.Player;

import java.io.Serializable;

public class Police extends NPC implements Serializable {
    public boolean deal;

    public Police(){
        super("Police");
        setName("Police");
        setLocation(1);
        deal = false;
    }

    public boolean getAtSameLoc(Mafia mafia){
        return mafia.getLocation() == this.getLocation();
    }

    public void arrestMafia(Mafia mafia){
        mafia.setIsArrested(true);
        // mafia.setLocation();
    }

    public void arrestPlayer(Player player){
        player.setIsArrested(true);
        // player.setLocation();
    }

    public boolean isDeal(){
        return deal;
    }
}
