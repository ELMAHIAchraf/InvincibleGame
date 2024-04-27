package org.example.Elixir;

public abstract class Elixir {
    private int hp;

    public Elixir(int hp) {
        this.hp = hp;
    }

    public int drinkElexir(){
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Elixir{" +
                "hp=" + hp +
                '}';
    }
}
