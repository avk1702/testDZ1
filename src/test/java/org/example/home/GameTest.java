package org.example.home;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Player player;
    private List<Door> doors;
    private Game game;

    @BeforeEach
    public void setUp() {
        player = new Player("Test Player", false);
        doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        game = new Game(player, doors);
    }

    @AfterEach
    public void tearDown() {
        player = null;
        doors = null;
        game = null;
    }

    @Test
    public void testRoundPlayerDoesNotChangeDoor_PrizeBehindSelectedDoor() {

        Door result = game.round(0);

       assertTrue(result.isPrize());
    }

    @Test
    public void testRoundPlayerDoesNotChangeDoor_PrizeBehindOtherDoor() {

        Door result = game.round(1);

        assertFalse(result.isPrize());
    }

    @Test
    public void testRoundInvalidDoorIndex() {

        assertThrows(IndexOutOfBoundsException.class, () -> game.round(2));
    }

    @Test
    public void testRoundPlayerIsNull() {

        game = new Game(null, doors);

        assertThrows(NullPointerException.class, () -> game.round(0));
    }


}