package entity.player;

import entity.Account;
import entity.PowerUp;
import entity.Trade;
import entity.card.Card;
import entity.card.CardDeck;
import entity.map.Tile.Tile;
import entity.map.property.Property;

import java.util.ArrayList;


public class Player extends Character{

    //properties
    private boolean isBankrupt;
    private ArrayList<PowerUp> powerUps;
    private Account account;
    private ArrayList<Card> cards; // This was CardDeck in diagram. Changed with card array.
    private ArrayList<Tile> tileList;
    private ArrayList<Property> properties;
    private boolean isArrested;
    private ArrayList<Trade> trades;
    private Playable playable;
    private int salary;
    private double speed;
    private int vehicleCount;

    //constructor
    public Player( Playable playable, String name){
        super(name);
        this.playable = playable;
        powerUps = new ArrayList<PowerUp>();
        tileList = new ArrayList<Tile>();
        properties = new ArrayList<Property>();
        trades = new ArrayList<Trade>();
        cards = new ArrayList<Card>();
        isArrested = false;
        isBankrupt = false;
        salary = 1;
        account = new Account( salary);
        speed = 1;
        vehicleCount = 0;
    }

    //Methods
    public void playTurn(){
        //TODO
    }

    public void useMafiaFavour(){ // ENUM enum
        //TODO
    }

    public void playCard(Card card) {
        //TODO
        removeFromDeck(card);
    }

    public boolean addTrade(Trade trade) {
        return trades.add(trade);
    }

    public boolean  removeTrade(Trade trade) {
        return trades.remove(trade);
    }

    public boolean addProperty(Property property){
        return properties.add(property);
    }

    public boolean removeProperty(Property property){
        return properties.remove(property);
    }

    public boolean addToDeck(Card card){
        return cards.add(card);
    }

    public boolean removeFromDeck(Card card){
        return cards.remove(card);
    }

    public boolean addPowerUp(PowerUp powerup){
        return powerUps.add(powerup);
    }

    public boolean removePowerUp(PowerUp powerup) {
        return powerUps.remove(powerup);
    }

    //get-set methods
    public boolean getIsArrested() {
        return isArrested;
    }

    public void setIsArrested(boolean arrested) {
        isArrested = arrested;
    }

    public boolean GetIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
