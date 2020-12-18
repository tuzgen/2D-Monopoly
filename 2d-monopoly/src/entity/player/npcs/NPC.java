package entity.player.npcs;

import entity.player.Character;

import java.io.Serializable;

public abstract class NPC extends Character implements Serializable {
    public NPC(String name) {
        super(name);
    }
}
