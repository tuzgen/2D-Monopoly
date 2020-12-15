package entity;

public abstract class Character {
    int location;
    String name;

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
