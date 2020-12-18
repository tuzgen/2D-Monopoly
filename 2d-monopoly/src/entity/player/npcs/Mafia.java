package entity.player.npcs;

import entity.Account;
import entity.Bank;
import entity.card.*;
import entity.map.tile.*;
import entity.player.Playable;
import entity.player.Player;
import entity.player.User;

import java.io.Serializable;
import java.util.*;

public class Mafia extends NPC implements Serializable {

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

    public boolean blackmail(Player blackmailedPlayer, Player player){ // 25% ihtimalle paraya çökmesi eklenebilir. Mafia PopUp da değiştirilmeli o casede
        Account account = player.getAccount(); // bide tur sınırı getirile bilir ona göre bırakıyorum şuan
        double money = account.getTrl() + account.getSwissFrank() + account.getEuro() + account.getDollar();
        money = money * BLACKMAILRATE / 100;
        bank.takeMoney(blackmailedPlayer, money);
        bank.giveMoney(player, money * (100 - shareRate) / 100);
        return true;
    }

    public boolean sellTile(int tile, Player player){
        // todo

        return true;
    }

    public String sellCard(Player player){ //başak false condition avr mı check it
        if(!bank.takeMoney(player, CARDAMOUNT))
            return "false";
        Card card = deck.drawCard(player);
        return card.getFeature();
    }

    public boolean getIsArrested(){
        return isArrested;
    }

    public void setIsArrested(boolean arrested){
        isArrested = arrested;
//        location = jailtile;
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
