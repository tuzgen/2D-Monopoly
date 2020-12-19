package entity.player;

import entity.Account;
import entity.Bank;
import entity.powerup.PowerUp;
import entity.Trade;
import entity.card.Card;
import entity.map.property.Property;
import entity.map.tile.CityTile;
import entity.map.tile.Tile;
import entity.powerup.PowerUpCrate;

import java.io.Serializable;
import java.util.ArrayList;


public class Player extends Character implements Serializable {

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
    private int startMoney;
    private int salary;
    private double speed;
    private int vehicleCount;

    //constructor
    public Player(Playable playable, String name){
        super(name);
        this.playable = playable;
        powerUps = new ArrayList<PowerUp>();
        tileList = new ArrayList<Tile>();
        properties = new ArrayList<Property>();
        trades = new ArrayList<Trade>();
        cards = new ArrayList<Card>();
        isArrested = false;
        isBankrupt = false;
        salary = 15000;
        startMoney = 500000; // TODO change initial money
        account = new Account(startMoney);
        speed = 1;
        vehicleCount = 0;
        tileList.add(new CityTile("Istanbul", 1, 1, 1, 1, 1, 1));
        tileList.add(new CityTile("Ankara", 1, 1, 1, 1, 1, 2));
        tileList.add(new CityTile("Izmir", 1, 1, 1, 1, 1, 3));
        tileList.add(new CityTile("Adana", 1, 1, 1, 1, 1, 4));
    }

    //Methods
    public void playTurn(){
        //TODO
        System.out.println(super.getName());
    }

    public void useMafiaFavour(){ // ENUM enum
        //TODO
    }

    public boolean playCard() {
        if(getIsArrested() && cards.size() != 0){
            Card c = cards.get(0);
            c.activateCard(this);
            removeFromDeck(c);
            return true;
        }
        return false;
    }

    public void setBehavior(Playable playable) { this.playable = playable; }

    public boolean addTrade(Trade trade) {
        return trades.add(trade);
    }

    public boolean  removeTrade(Trade trade) {
        return trades.remove(trade);
    }

    public boolean addProperty(Property property){
        return properties.add(property);
    }

    public boolean addToTileList(Tile tile) {
        return tileList.add(tile);
    }

    public boolean removeFromTileList(Tile tile) {
        return tileList.remove(tile);
    }

    public boolean containsTile(Tile tile) {
        return tileList.contains(tile);
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

    public  ArrayList<Trade> getTrades(){ return trades; }

    public boolean getIsArrested() {
        return isArrested;
    }

    public void setIsArrested(boolean arrested) {
        isArrested = arrested;
        if( arrested)
            setLocation(10);
    }

    public boolean GetIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public void addToAccount(int amount) {
        account.setTrl(account.getTrl() + amount);
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

    public int getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(int startMoney) {
        this.startMoney = startMoney;
    }

    public ArrayList<Tile> getTileList(){
        return tileList;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + getName() + "\nLocation: " + getLocation() + "\n";
    }

    public ArrayList<PowerUp> getPowerUps(){
        return powerUps;
    }

    public ArrayList<Card> getCards() { return cards; }
}

