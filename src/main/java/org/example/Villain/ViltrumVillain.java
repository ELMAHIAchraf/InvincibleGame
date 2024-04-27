package org.example.Villain;

import org.example.Elixir.Elixir;
import org.example.Hero.Heros;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public abstract class ViltrumVillain implements Cloneable{

    private String Cname;
    private int health=100;
    private int damage;
    private int rageBuff;
    private List<Heros> heros;
    boolean isHalfHP=false;
    private Timer timer;

    public final void startBattle(){
        preBattleLine();
        fightSche();
    }
    protected abstract void preBattleLine();
    protected void fightSche(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(health>0){
                    try {
                        fight();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    timer.cancel();
                    for (Heros hero : heros){
                        hero.getTimer().cancel();
                    }
                    System.out.println("The viltrumite died, YOU WON");
                    System.exit(0);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 200);
    }
    public void damage(int damage) throws InterruptedException {
        if(damage > health){
            health=0;
        }else{
            health-=damage;
        }
        System.out.println(Cname+" got "+damage+" HP damage");
    }

    public void fight() throws InterruptedException {
        if (health<=50 && !isHalfHP){
            Elixir elexir = getElexir();
            health+=elexir.drinkElexir();
            isHalfHP=true;
            System.out.println("+"+Cname+ " healed "+elexir.drinkElexir()+" HP");
        }
        if(health<=20){
            damage+=damage*rageBuff/100;
        }
        if(heros.size()>0){
            Random random = new Random();
            heros.get(random.nextInt(heros.size())).damage(damage);
        }

    }

    public static ViltrumVillain getRandomVillain() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("org.example.Villain");
        List<Class<? extends ViltrumVillain>> subTypes = new ArrayList<>(reflections.getSubTypesOf(ViltrumVillain.class));
        Random random = new Random();
        Class<? extends ViltrumVillain> randomVillain = subTypes.get(random.nextInt(subTypes.size()));
        System.out.println(randomVillain.getSimpleName());
        if(randomVillain.getSimpleName().equals("RognarrAdapter")){
            return new RognarrAdapter(new Rognarr());
        }
        return randomVillain.getDeclaredConstructor().newInstance();
    }


    public ViltrumVillain clone() {
        try {
            return (ViltrumVillain) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public abstract Elixir getElexir();

    public ViltrumVillain(String name, int damage, int rageBuff) {
        this.Cname = name;
        this.damage = damage;
        this.rageBuff = rageBuff;
    }
    public String getCname() {
        return Cname;
    }

    public void setCname(String name) {
        this.Cname = Cname;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRageBuff() {
        return rageBuff;
    }

    public void setRageBuff(int rageBuff) {
        this.rageBuff = rageBuff;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Heros> getHeros() {
        return heros;
    }

    public void setHeros(List<Heros> heros) {
        this.heros = heros;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "Villain{" +
                "Cname='" + Cname + '\'' +
                ", damage=" + damage +
                ", rageBuff=" + rageBuff +
                '}';
    }
}
