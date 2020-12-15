package entity.player;

public abstract class Character {
    private int location;
    private String name;

    public Character(String name){
        location = 0;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int tileNumber) {
        this.location = tileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
