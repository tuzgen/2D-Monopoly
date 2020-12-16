package entity.player;

import entity.Bank;
import entity.player.npcs.Mafia;
import entity.player.npcs.Police;

public class BotCreator {

    public BotCreator(Bank bank){
        createPolice();
        createBots();
        createMafia(bank);
    }

    public void createPolice(){
        Police police = new Police();
    }

    public void createMafia(Bank bank){
        Mafia mafia = new Mafia(bank);
    }

    public void createBots(){
        // todo
    }
}
