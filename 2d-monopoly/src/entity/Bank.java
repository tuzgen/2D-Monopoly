package entity;

import entity.player.Player;
import gui.menus.controller.GameMenuController;
import management.ForexManager;
import management.GameManager;

public class Bank { // Methods in this class may be static so that no one need bank object.
    private static Bank instance;

    private ForexManager forexManager;
    private Forex forex;
    private Account plAccount;

    private Bank(){
        this.forexManager = ForexManager.getInstance();
        forex = forexManager.getForex();
    }

    public static Bank getInstance() {
        if (instance == null)
            instance = new Bank();
        return instance;
    }

    public boolean swapMoney(Player payerPlayer, Player payeePlayer, double moneyAmount) { //Check if payer does not have enough money after todo in takeMoney function
        if(moneyAmount == 0)
            return true;
        if(takeMoney(payerPlayer, moneyAmount)){
            giveMoney(payeePlayer, moneyAmount);
            return true;
        }
        return false;
    }

    public boolean giveMoney(Player player, double moneyAmount){
        plAccount = player.getAccount();
        plAccount.setTrl(plAccount.getTrl() + moneyAmount);
        return true;
    }

    public  boolean hasEnoughMoney(Player player, double amount) {
        plAccount = player.getAccount();
        double totalMoney = (player.getAccount().getDollar()) * forex.getDollarExRate()
                + (player.getAccount().getEuro()) * forex.getEuroExRate()
                + (player.getAccount().getSwissFrank()) * forex.getFrankExRate()
                + (player.getAccount().getTrl());
        if(totalMoney >= amount)
            return true;
        return false;
    }

    public boolean hasEnoughTRY(Player player, double amount) {
        return player.getAccount().getTrl() >= amount;
    }


    public boolean takeMoney(Player player, double moneyAmount) {
        plAccount = player.getAccount();
        double totalMoney = (player.getAccount().getDollar()) * forex.getDollarExRate()
                                + (player.getAccount().getEuro()) * forex.getEuroExRate()
                                + (player.getAccount().getSwissFrank()) * forex.getFrankExRate()
                                + (player.getAccount().getTrl());

        if(totalMoney >= moneyAmount){
            if (plAccount.getTrl() >= moneyAmount)
                plAccount.setTrl(plAccount.getTrl() - moneyAmount);
            else {
                moneyAmount -= plAccount.getTrl();
                plAccount.setTrl(0);
                if(plAccount.getDollar() * forex.getDollarExRate() >= moneyAmount)
                    plAccount.setDollar(plAccount.getDollar() - (moneyAmount / forex.getDollarExRate()));
                else{
                    moneyAmount -= plAccount.getDollar() * forex.getDollarExRate();
                    plAccount.setDollar(0);
                    if(plAccount.getEuro() * forex.getEuroExRate() >= moneyAmount)
                        plAccount.setEuro(plAccount.getEuro() - (moneyAmount / forex.getEuroExRate()));
                    else{
                        moneyAmount -= plAccount.getEuro() * forex.getEuroExRate();
                        plAccount.setEuro(0);
                        if(plAccount.getSwissFrank() * forex.getFrankExRate() >= moneyAmount)
                            plAccount.setSwissFrank(plAccount.getSwissFrank() - (moneyAmount / forex.getFrankExRate()));
                        else{
                            moneyAmount -= plAccount.getSwissFrank() * forex.getFrankExRate();
                            plAccount.setSwissFrank(0);
                        }
                    }
                }
            }

            return true;
        } else {
            //TODO
            return false;
        }
    }
}
