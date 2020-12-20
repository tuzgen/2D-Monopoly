package entity.player;

import entity.Account;
import entity.Bank;
import entity.card.GetOutOfJailCardStrategy;
import entity.powerup.PowerUp;
import entity.Trade;
import entity.card.Card;
import entity.map.property.Property;
import entity.map.tile.CityTile;
import entity.map.tile.Tile;
import entity.powerup.PowerUpCrate;
import management.Map;

import java.io.Serializable;
import java.util.ArrayList;


public class Player extends Character implements Serializable {

    //properties
    private boolean isBankrupt;
    private ArrayList<PowerUp> powerUps;
    private int slowDownLifetime;
    private boolean isSlowedDown;
    private boolean isEarningMore;
    private int earningLifeTime;
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
    private final double INITIAL_SPEED = 1.0;
    private final int INITIAL_SALARY = 15000;
    private int vehicleCount, companyCount;

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
        isSlowedDown = false;
        isEarningMore = false;
        salary = 15000;
        startMoney = 500000; // TODO change initial money
        account = new Account(startMoney);
        speed = 1;
        vehicleCount = 0; // TODO increment these when player buys them
        companyCount = 0; // TODO increment these when player buys them
        slowDownLifetime = 0;
        earningLifeTime = 0;
    }

    //Methods
    // DEBUG
    public void displayTiles() {
        System.out.println(getName());
        System.out.println(tileList.toString());
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

    public void deActivateSlow(){
        setIsSlowedDown(false);
        speed = INITIAL_SPEED;
    }

    public void deActivateEarn(){
        setIsEarningMore(false);
        setEarningLifeTime(0);
        account.setPoweupRate(1);
    }

    //get-set methods

    public  ArrayList<Trade> getTrades(){ return trades; }

    public boolean getIsArrested() {
        return isArrested;
    }

    public void setIsArrested(boolean arrested) {
        isArrested = arrested;
        if( arrested)
            setLocation(Map.JAILNO);
    }

    public boolean getIsBankrupt() {
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

    public double getInitialSpeed() {
        return INITIAL_SPEED ;
    }

    public boolean getIsSlowedDown() {
        return isSlowedDown;
    }

    public void setIsSlowedDown(Boolean slowed) {
        isSlowedDown = slowed;
    }

    public int getSlowDownLifetime() {
        return slowDownLifetime;
    }

    public void setSlowDownLifetime(int slowDownLifetime) {
        this.slowDownLifetime = slowDownLifetime;
    }

    public int getEarningLifeTime() {
        return earningLifeTime;
    }

    public void setEarningLifeTime(int earningLifeTime) {
        this.earningLifeTime = earningLifeTime;
    }

    public boolean getIsEarningMore(){
        return isEarningMore;
    }

    public void setIsEarningMore(boolean earningMore) {
        isEarningMore = earningMore;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) { this.vehicleCount = vehicleCount; }

    public int getCompanyCount() { return companyCount; }

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

