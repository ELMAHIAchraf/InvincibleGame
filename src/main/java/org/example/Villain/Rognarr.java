package org.example.Villain;

public class Rognarr{

    private final String Cname = "Rognarr";
    private final int damage =16;
    private final int rageBuff = 25;

    public void scream(){
        System.out.println("AAAAAAAAAAAAARGH!");
    }

    public String getCname() {
        return Cname;
    }

    public int getDamage() {
        return damage;
    }

    public int getRageBuff() {
        return rageBuff;
    }
}