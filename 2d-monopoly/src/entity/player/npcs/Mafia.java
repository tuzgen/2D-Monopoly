package entity.player.npcs;

import entity.Account;
import entity.Bank;
import entity.card.*;
import entity.map.tile.*;
import management.Map;
import entity.player.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Mafia extends NPC implements Serializable {

    public static final double TILE_DISCOUNT = 0.8;
    private final double JAILBREAKAMOUNT = 50000;
    private final double CARDAMOUNT = 20000;
    private final int BLACKMAILRATE = 15;

    private double shareRate;
    private CardDeck deck;
    public boolean isArrested;
    ArrayList<Player> pastDeals;
    private Bank bank;

    public Mafia(){
        super("Mafia");
        isArrested = false;
        shareRate = 15;
        bank = bank.getInstance();
        pastDeals = new ArrayList<Player>();
        deck = new CardDeck(false, true);
        deck.createDeck();
    }

    public boolean jailbreak(Player player){
        if(player.getIsArrested()){
            if(!bank.takeMoney(player, JAILBREAKAMOUNT))
                return false;
            player.setIsArrested(false);
            return true;
        }
        return false;
    }


    public void attackHotel(Tile tile){
        //todo
    }

    public int blackmail(Player blackmailedPlayer, Player player){
        double rate = Math.floor(((int) Math.floor(Math.random()*4)));
        double money = bank.getAllMoneyAmount(blackmailedPlayer);
        if(!bank.takeMoney(player, 5000))
            return 0;
        money = money * BLACKMAILRATE / 100;
        if(rate == 2) {
            double mymoney = bank.getAllMoneyAmount(player);
            bank.takeMoney(player, mymoney * BLACKMAILRATE / 100);
            return 2;
        } else
            bank.takeMoney(blackmailedPlayer, money);
        addDeal( player );
        return 1;
    }


    public boolean sellTile(int tile, Player player){
        // todo
        addDeal( player );
        return true;
    }

    public String sellCard(Player player){ // başak false condition avr mı check it
        if(!bank.takeMoney(player, CARDAMOUNT))
            return "false";
        Card card = deck.drawCard(player);
        addDeal( player );
        return card.getFeature();
    }

    public boolean getIsArrested(){
        return isArrested;
    }

    public void setIsArrested(boolean arrested){
        isArrested = arrested;
        setLocation(10);

        for(int i = pastDeals.size()-1; i > pastDeals.size()-6; i--){
            if(i <= 0)
                break;
            pastDeals.get(i).setIsArrested(true);
        }
        pastDeals.clear();

    }

    public void addDeal(Player player){
        pastDeals.add(player);
    }

    public void deleteDeal(Player player){
        pastDeals.remove(player);
    }

    public ArrayList<Player> getDeals(){
        return pastDeals;
    }

    public double getShareRate() {
        return shareRate;
    }

    public void setShareRate(double rate){
        this.shareRate = rate;
    }
}
