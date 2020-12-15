package entity;

//import entity.map.Tile;
import entity.player.Player;

import java.util.*;

public class Mafia extends Character{

    public double shareRate;
    public boolean isArrested;
    ArrayList<Player> pastDeals;

    Mafia(){
        isArrested = false;
        shareRate = 0;
        pastDeals = new ArrayList<Player>();
    }

//    public void attackHotel(Tile tile){
//        //todo
//    }

    public void blackmail(Player player){
        // todo
    }

    public double getShareRate() {
        return shareRate;
    }

    public void setShareRate(double rate){
        this.shareRate = rate;
    }

    public boolean sellTile(int tile){
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
