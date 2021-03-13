package main;

public class Owner {
    private final String name;
    private static int counterID = 0;
    private final int ownerID;

    public Owner() {
        this.name = "Owner " + (this.ownerID = ++counterID);
    }

    public String getName() {
        return name;
    }

    public int getOwnerID() {
        return ownerID;
    }
}