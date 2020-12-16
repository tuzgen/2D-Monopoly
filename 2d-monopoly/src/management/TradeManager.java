package management;

import entity.Bank;
import entity.Trade;
import entity.map.tile.Tile;
import entity.player.Player;

public class TradeManager {
    private static TradeManager tradeManager;
    private Bank bank;

    private TradeManager(){
        bank = new Bank(ForexManager.getInstance());
    }

    public static TradeManager getInstance(){
        if(tradeManager == null)
            tradeManager = new TradeManager();
        return tradeManager;
    }

    public boolean openTrade(Player owner, Player targetPlayer, Tile[] targetTiles, Tile[] offeredTiles, int offeredAmount, int requestedAmount) {
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

    public boolean checkTrades(Player owner, Player targetPlayer, Tile[] targetTiles, Tile[] offeredTiles) { // This methods functionality might be implemented in UI so it may be removed
        for(int i = 0; i < offeredTiles.length; i++)
            if(!owner.containsTile(offeredTiles[i]))
                return false;
        for(int k = 0; k < targetTiles.length; k++)
            if(!targetPlayer.containsTile(offeredTiles[k]))
                return false;
        return true; // Some other things may be added
    }

    public void acceptTrade(Trade trade) {
       Player owner = trade.getOwner();
       Player targetPlayer = trade.getTarget();

       for(int i = 0; i < trade.getOwnersTile().length; i++){
           owner.removeFromTileList(trade.getOwnersTile()[i]);
           targetPlayer.addToTileList(trade.getOwnersTile()[i]);
       }
       for(int k = 0; k < trade.getTargetTile().length; k++){
           targetPlayer.removeFromTileList(trade.getTargetTile()[k]);
           owner.addToTileList(trade.getTargetTile()[k]);
       }
       bank.swapMoney(owner, targetPlayer, trade.getOfferedAmount());
       bank.swapMoney(targetPlayer, owner, trade.getRequestedAmount());

       owner.removeTrade(trade);
       targetPlayer.removeTrade(trade);
    }

    public void denyTrade(Trade trade) { // This only deletes from the target lists in players
        Player owner = trade.getOwner();
        Player targetPlayer = trade.getTarget();
        owner.removeTrade(trade);
        targetPlayer.removeTrade(trade);
    }
}