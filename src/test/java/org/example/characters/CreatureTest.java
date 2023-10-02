package org.example.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    Creature creature;

    @BeforeEach
    void init(){
        creature = new Monster(30, 30, 50, 5, 10);
    }

    @Test
    void test_levelUp() {
        creature.levelUp();

        assertEquals(2, creature.getLevel());
    }

    @Test
    void test_improveParameters() {
        creature.improveParameters();

        assertAll(
                () -> assertEquals(31, creature.getAttack()),
                () -> assertEquals(31, creature.getProtection()),
                () -> assertEquals(55, creature.getMaxHealth()),
                () -> assertEquals(55, creature.getCurrentHealth()),
                () -> assertEquals(6, creature.getMinDamage()),
                () -> assertEquals(11, creature.getMaxDamage())
        );
    }

    @Test
    void test_levelUpHealthWithFull() {
        creature.levelUpHealth();

        assertAll(
                () -> assertEquals(55, creature.getMaxHealth()),
                () -> assertEquals(55, creature.getCurrentHealth())
        );
    }


    @Test
    void test_levelUpHealthWithoutFull() {
        creature.setCurrentHealth(40);
        creature.levelUpHealth();

        assertAll(
                () -> assertEquals(55, creature.getMaxHealth()),
                () -> assertEquals(44, creature.getCurrentHealth())
        );
    }


    @Test
    void test_takeDamage() {
        creature.takeDamage(6, 10);
        assertEquals(42, creature.getCurrentHealth(), 2);
    }

    @Test
    void test_hit() {
        Creature creatureTwo = new Monster(30, 30, 50, 5, 10);
        creatureTwo.hit(creature);
        assertEquals(45, creature.getCurrentHealth(), 5);
    }

    @Test
    void test_die() {
        creature.die();
        assertTrue(creature.isDead());
    }
}