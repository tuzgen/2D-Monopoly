package entity;

import entity.map.tile.Tile;
import entity.player.Player;

import java.util.ArrayList;

public class Trade {
    private Player owner;
    private Player target;
    private ArrayList<Tile> ownersTile;
    private ArrayList<Tile> targetTile;
    private int offeredAmount;
    private int requestedAmount;

    public Trade(Player owner, Player target){
        this.owner = owner;
        this.target = target;
        ownersTile = new ArrayList<Tile>();
        targetTile = new ArrayList<Tile>();
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

    public ArrayList<Tile> getTargetTile() {
        return targetTile;
    }

    public void setTargetTile(ArrayList<Tile> targetTile) {
        this.targetTile = targetTile;
    }

    public ArrayList<Tile> getOwnersTile() {
        return ownersTile;
    }

    public void setOwnersTile(ArrayList<Tile> ownersTile) {
        this.ownersTile = ownersTile;
    }
}
