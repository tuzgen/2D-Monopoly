package entity.player;

import entity.Bank;
import entity.player.npcs.Mafia;
import entity.player.npcs.Police;

import java.io.Serializable;

public class BotCreator implements Serializable {

    public BotCreator(){
        createPolice();
        createBots();
        createMafia();
    }

    public void createPolice(){
        Police police = new Police();
    }

    public void createMafia(){
        Mafia mafia = new Mafia();
    }

    public void createBots(){
        // todo
    }
}
