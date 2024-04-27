package org.example;

import org.example.Hero.Heros;
import org.example.Villain.ViltrumVillain;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        Random random = new Random();


        ViltrumVillain villain = ViltrumVillain.getRandomVillain();
        System.out.println("Press Enter to stop the game");
        System.out.println("----------WARNING : " + villain.getCname() + " is coming to conquer earth----------");
        List<Heros> heros = Heros.chooseDefenders();

        villain.setHeros(heros);
        villain.startBattle();

        for (Heros hero : heros) {
            hero.setVillain(villain);
            hero.fightSche();
        }

        input.nextLine();

        villain.getTimer().cancel();
        for (Heros hero : heros) {
            hero.getTimer().cancel();
        }
    }
}