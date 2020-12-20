package management;

import entity.Bank;
import entity.Trade;
import entity.map.tile.Tile;
import entity.player.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class TradeManager implements Serializable {
    private static TradeManager instance;
    private Bank bank;

    private TradeManager(){
        bank = Bank.getInstance();
    }

    public static TradeManager getInstance(){
        if(instance == null)
            instance = new TradeManager();
        return instance;
    }

    public boolean openTrade(Player owner, Player targetPlayer, ArrayList<Tile> targetTiles, ArrayList<Tile> offeredTiles, int offeredAmount, int requestedAmount) {
        Trade trade = new Trade(owner, targetPlayer);
        trade.setOfferedAmount(offeredAmount);
        trade.setRequestedAmount(requestedAmount);
        trade.setOwnersTile(offeredTiles);
        trade.setTargetTile(targetTiles);

        if(checkTrades(owner, targetPlayer, targetTiles, offeredTiles)){
            owner.addTrade(trade);
            targetPlayer.addTrade(trade);
            return true;
        }
        return false;
    }

    public boolean checkTrades(Player owner, Player targetPlayer, ArrayList<Tile> targetTiles, ArrayList<Tile> offeredTiles) { // This methods functionality might be implemented in UI so it may be removed
        for(int i = 0; i < offeredTiles.size(); i++)
            if (!owner.containsTile(offeredTiles.get(i)))
                return false;

        for(int k = 0; k < targetTiles.size(); k++)
            if (!targetPlayer.containsTile(targetTiles.get(k)))
                return false;
        return true; // Some other things may be added
    }

    public boolean acceptTrade(Trade trade) {
       Player owner = trade.getOwner();
       Player targetPlayer = trade.getTarget();

        if(!bank.swapMoney(owner, targetPlayer, trade.getOfferedAmount()))
            return false;
        if(!bank.swapMoney(targetPlayer, owner, trade.getRequestedAmount()))
            return false;

       for(int i = 0; i < trade.getOwnersTile().size(); i++){
           owner.removeFromTileList(trade.getOwnersTile().get(i));
           targetPlayer.addToTileList(trade.getOwnersTile().get(i));
       }
       for(int k = 0; k < trade.getTargetTile().size(); k++){
           targetPlayer.removeFromTileList(trade.getTargetTile().get(k));
           owner.addToTileList(trade.getTargetTile().get(k));
       }

       owner.removeTrade(trade);
       targetPlayer.removeTrade(trade);
       
       return true;
    }

    public void denyTrade(Trade trade) { // This only deletes from the target lists in players
        Player owner = trade.getOwner();
        Player targetPlayer = trade.getTarget();
        owner.removeTrade(trade);
        targetPlayer.removeTrade(trade);
    }

	public void deleteInstance() {
        // bank.deleteInstance();
        instance = null;
	}
}