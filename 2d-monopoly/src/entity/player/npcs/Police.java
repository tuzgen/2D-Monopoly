package entity.player.npcs;

import entity.player.Player;

public class Police extends NPC {
    public boolean deal;

    Police(){
        super("Police");
        setName("Police");
        setLocation(1);
        deal = false;
    }

    public boolean getAtSameLoc(){
        // todo
        return true;
    }

    public void arrestMafia(){
        //todo
    }

    public void arrestPlayer(Player player){
        //todo
    }

    public boolean isDeal(){
        return deal;
    }
}
