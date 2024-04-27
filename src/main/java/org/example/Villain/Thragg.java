package org.example.Villain;

import org.example.Elixir.Elixir;
import org.example.Elixir.VigorElexir;

public class Thragg extends ViltrumVillain {

    public Thragg() {
        super("Thragg", 22, 35);
    }

    @Override
    protected void preBattleLine() {
        System.out.println("I am Thragg, Grand Regent of Viltrum, and Earth shall bow before its new ruler.");
    }

    public Elixir getElexir(){
        return new VigorElexir();
    }

}
