package management;

import entity.Trade;
import entity.player.Player;

public class TradeManager {
    private static TradeManager tradeManager;

    private TradeManager(){    }

    public TradeManager getInstance(){
        if(tradeManager == null)
            tradeManager = new TradeManager();
        return tradeManager;
    }

    public Trade openTrade(Player owner, Player targetPlayer) {
        Trade trade = new Trade(owner, targetPlayer);
        return null;
    }

    public boolean checkTrades() {
        //TODO
        return false;
    }

    public void acceptTrade(Trade trade, Player player) {
        //TODO
    }

    public void denyTrade(Trade trade, Player player) {
        //TODO
    }
}