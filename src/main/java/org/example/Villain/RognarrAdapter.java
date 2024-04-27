package org.example.Villain;

import org.example.Elixir.Elixir;
import org.example.Elixir.LuminousNectar;

public class RognarrAdapter extends ViltrumVillain {
    private Rognarr rognarr;

    public RognarrAdapter(Rognarr rognarr) {
        super(rognarr.getCname(), rognarr.getDamage(), rognarr.getRageBuff());
        this.rognarr=rognarr;
    }

    public void setRognarr(Rognarr rognarr) {
        this.rognarr = rognarr;
    }

    @Override
    protected void preBattleLine() {
        rognarr.scream();
    }

    @Override
    public Elixir getElexir() {
        return new LuminousNectar();
    }
}
