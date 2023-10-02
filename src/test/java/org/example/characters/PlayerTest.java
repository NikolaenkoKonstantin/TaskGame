package org.example.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;

    @BeforeEach
    void init(){
        player = new Player(30, 30, 50, 5, 10);
    }

    @Test
    void test_healYourselfAtFullHealth() {
        player.healYourself();

        assertEquals(50, player.getCurrentHealth());
    }

    @Test
    void test_healYourselfAtPartialHealth() {
        player.setCurrentHealth(30);

        player.healYourself();

        assertEquals(45, player.getCurrentHealth());
    }
}