package entity;

import entity.map.Tile.Tile;
import entity.player.Player;

public class Trade {
    private Player owner;
    private Player target;
    private Tile[] ownersTile;
    private Tile[] targetTile;
    private int offeredAmount;
    private int requestedAmount;

    public Trade(){
        ownersTile = new Tile[22];
        targetTile = new Tile[22];
        offeredAmount = 0;
        requestedAmount = 0;
    }

    public int getOfferedAmount() {
        return offeredAmount;
    }

    public void setOfferedAmount(int offeredAmount) {
        this.offeredAmount = offeredAmount;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public Tile[] getTargetTile() {
        return targetTile;
    }

    public void setTargetTile(Tile[] targetTile) {
        this.targetTile = targetTile;
    }

    public Tile[] getOwnersTile() {
        return ownersTile;
    }

    public void setOwnersTile(Tile[] ownersTile) {
        this.ownersTile = ownersTile;
    }
}
