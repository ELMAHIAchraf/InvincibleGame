package org.example.Hero;

import org.example.Villain.ViltrumVillain;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Heros implements Cloneable{

    private String Cname;
    private int health=100;
    private int price;
    private int damage;
    private ViltrumVillain villain;
    private Timer timer;

    public static List<Heros> chooseDefenders() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        Reflections reflections = new Reflections("org.example.Hero");
        List<Class<? extends Heros>> subTypes = new ArrayList<>(reflections.getSubTypesOf(Heros.class));

        List<Heros> heros = new ArrayList();
        for (Class<? extends Heros> subType : subTypes){
            heros.add((Heros) Class.forName(subType.getPackageName()+"."+subType.getSimpleName()).getDeclaredConstructor().newInstance());
        }

        System.out.println("You have 25$ to spend on deffenders");
        System.out.println("-----Defenders List------");

        heros.sort((h1, h2)->h2.getPrice()-h1.getPrice());
        int i = 1;
        for (Heros hero : heros){
            System.out.println(i+"- "+hero.getCname()+" -> "+hero.getPrice()+"$");
            i++;
        }


        int spent=0;
        String theChosenOnes;
        List<Integer> choices;
        List<Heros> defenders= new ArrayList<>();
        while (true){
            System.out.println("Enter your choices seperated by commas (1,10)");
            theChosenOnes = input.nextLine();
            choices = List.of(theChosenOnes.split(",")).stream().map((choice->Integer.parseInt(choice))).toList();
            for (int choice : choices){
                spent+=heros.get(choice-1).getPrice();
            }
            if (spent<=25){
                for (int choice : choices){
                    defenders.add(heros.get(choice-1).clone());
                }
                String fight="Deffenders: ";
                for (Heros defender : defenders){
                    fight+=defender.getClass().getSimpleName()+", ";
                }
                fight=fight.substring(0, fight.lastIndexOf(","));
                System.out.println(fight);
                System.out.println("-----THE FIGHT BEGINS-----");
                break;
            }else {
                System.out.println("You spent more than 25$, choose again");
                spent=0;
            }
        };
        return defenders;

    }

    public void damage(int damage) throws InterruptedException {
        if(damage >= health){
            health = 0;
            System.out.println(Cname + " got " + damage + " HP damage");
        }else{
            if(health>0) {
                health-=damage;
                System.out.println(Cname + " got " + damage + " HP damage");

            }
        }
    }
    public void fightSche(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(health>0){
                    fight();
                }else {
                    for(int i=0; i<villain.getHeros().size(); i++){
                        if(villain.getHeros().get(i).getCname().equals(Cname)){
                            villain.getHeros().remove(i);
                            System.out.println(Cname+" Died");
                            timer.cancel();
                            break;
                        }
                    }
                    if(villain.getHeros().isEmpty()){
                        villain.getTimer().cancel();
                        System.out.println("You lost Earth is now under the rule of the Viltrum Empire");
                        System.exit(0);
                    }

                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 200);
    }
    public void fight() {
        try {
            if(villain.getHealth()>0) {
                villain.damage(damage);
            }else{
                villain.getTimer().cancel();
            }
        }catch (InterruptedException e){}
    }

    public Heros(String name, int damage, int price) {
        this.Cname = name;
        this.damage = damage;
        this.price=price;
    }

    @Override
    public Heros clone() throws CloneNotSupportedException {
        Heros clone = (Heros) super.clone();
        if (villain != null) {
            clone.villain = villain.clone();
        }
        return clone;
    }


    public String getCname() {
        return Cname;
    }

    public void setCname(String name) {
        this.Cname = Cname;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ViltrumVillain getVillain() {
        return villain;
    }

    public void setVillain(ViltrumVillain villain) {
        this.villain = villain;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "Heros{" +
                "Cname='" + Cname + '\'' +
                ", health=" + health +
                ", price=" + price +
                ", damage=" + damage +
                ", villain=" + villain +
                '}';
    }
}