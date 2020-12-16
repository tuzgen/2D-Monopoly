package entity.player.npcs;

import entity.player.Player;

public class Police extends NPC {
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
    }

    public void arrestPlayer(Player player){
        player.setIsArrested(true);
    }

    public boolean isDeal(){
        return deal;
    }
}
