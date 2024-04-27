package org.example.Villain;

import org.example.Elixir.Elixir;
import org.example.Elixir.PhoenixDew;

public class Conquest extends ViltrumVillain {
    protected Conquest() {
        super("Conquest", 18, 30);
    }

    @Override
    protected void preBattleLine() {
        System.out.println("I am Conquest, the harbinger of Viltrum's dominance, and Earth shall fall beneath my unstoppable might.");
    }

    public Elixir getElexir(){
        return new PhoenixDew();
    }

}
