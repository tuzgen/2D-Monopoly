package entity.player.npcs;

import entity.Account;
import entity.Bank;
import entity.map.tile.*;
import entity.player.Playable;
import entity.player.Player;
import entity.player.User;

import java.util.*;

public class Mafia extends NPC {

    private double JAILBREAKAMOUNT = 50000;
    private int BLACKMAILRATE = 15;
    private double shareRate;
    public boolean isArrested;
    ArrayList<Player> pastDeals;
    private Bank bank;

    public Mafia(){
        super("Mafia");
        isArrested = false;
        shareRate = 15;
        bank = bank.getInstance();
        pastDeals = new ArrayList<Player>();
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
        Account account = player.getAccount();
        double money = account.getTrl() + account.getSwissFrank() + account.getEuro() + account.getDollar();
        money = money * BLACKMAILRATE / 100;
        bank.takeMoney(blackmailedPlayer, money);
        bank.giveMoney(player, money * (100 - shareRate) / 100);
        return true;
    }

    public double getShareRate() {
        return shareRate;
    }

    public void setShareRate(double rate){
        this.shareRate = rate;
    }

    public boolean sellTile(int tile, Player player){
        // todo

        return true;
    }

    public boolean sellChanceCard(){
        // todo
        return true;
    }

    public boolean sellCommunityCard(){
        // todo
        return true;
    }

    public boolean getIsArrested(){
        return isArrested;
    }

    public void setIsArrested(boolean arrested){
        isArrested = arrested;
//        location = jailtile;
    }

    public void addDeal(Player player){
        // todo
    }

    public boolean deleteDeal(Player player){
        // todo
        return true;
    }

    public ArrayList<Player> getDeals(){
        return pastDeals;
    }
}
