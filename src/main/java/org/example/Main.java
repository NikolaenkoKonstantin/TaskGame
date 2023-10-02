package org.example;

import org.example.characters.Monster;
import org.example.characters.Player;

public class Main {
    public static void main(String[] args) {
        // Battle between two players and two monsters. When killed, a level up occurs.
        Player firstPlayer = new Player(30, 25, 30, 1, 6);
        Player secondPlayer = new Player(30, 25, 40, 1, 6);

        Monster firstMonster = new Monster(30, 25, 10, 9, 13);
        Monster secondMonster = new Monster(30, 25, 5, 5, 10);

        firstMonster.hit(firstPlayer);
        System.out.println();
        firstPlayer.hit(firstMonster);
        System.out.println();
        firstMonster.hit(firstPlayer);
        System.out.println();
        firstPlayer.hit(firstMonster);
        System.out.println();

        secondPlayer.hit(secondMonster);
        System.out.println();
        secondMonster.hit(secondPlayer);
        System.out.println();
        secondPlayer.hit(secondMonster);
        System.out.println();
        secondMonster.hit(secondPlayer);
        System.out.println();

        //get healed
        System.out.println("First player " + firstPlayer.getCurrentHealth() + "health");
        firstPlayer.healYourself();
        System.out.println("First player " + firstPlayer.getCurrentHealth() + "health");
        firstPlayer.healYourself();
        System.out.println("First player " + firstPlayer.getCurrentHealth() + "health" + "\n");

        //If there are still healings, but health is complete,
        // then there is no point in being treated, that is, treatment does not occur
        System.out.println("Second player " + secondPlayer.getCurrentHealth() + "health");
        secondPlayer.healYourself();
        System.out.println("Second player " + secondPlayer.getCurrentHealth() + "health");
        secondPlayer.healYourself();
        System.out.println("Second player " + secondPlayer.getCurrentHealth() + "health");
        secondPlayer.healYourself();
        System.out.println("Second player " + secondPlayer.getCurrentHealth() + "health");
        secondPlayer.healYourself();
        System.out.println("Second player " + secondPlayer.getCurrentHealth() + "health");
        secondPlayer.healYourself(); // Called once again to see that healing does not work more than 4 times
        System.out.println("Second player " + secondPlayer.getCurrentHealth() + "health");
    }
}