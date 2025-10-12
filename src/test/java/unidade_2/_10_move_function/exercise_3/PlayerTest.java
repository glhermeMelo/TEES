package unidade_2._10_move_function.exercise_3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    private Player createTestPlayerWithItems() {
        Player player = new Player("TestPlayer", 100, 10, 5);
        Item sword = new Item("Sword", "Sharp", ItemType.WEAPON, 15);
        Item potion = new Item("Potion", "Heals", ItemType.POTION, 30);
        player.getInventory().addItem(sword);
        player.getInventory().addItem(potion);
        return player;
    }

    @Test
    void takeDamage_shouldReduceHealth() {
        Player player = new Player("Test", 100, 10, 1);
        player.takeDamage(20);
        assertEquals(80, player.getHealth());
    }

    @Test
    void heal_shouldIncreaseHealth() {
        Player player = new Player("Test", 50, 10, 1);
        player.heal(30);
        assertEquals(80, player.getHealth());
    }

    @Test
    void equipWeapon_shouldEquipIfInInventory() {
        Player player = new Player("Test", 100, 10, 1);
        Item sword = new Item("Sword", "Sharp", ItemType.WEAPON, 15);
        player.getInventory().addItem(sword);
        player.equipWeapon(sword);
        assertEquals(sword, player.getEquippedWeapon());
        assertTrue(outContent.toString().contains("Test equipou: Sword"));
    }

    @Test
    void useItem_potionShouldHealAndBeRemoved() {
        Player player = createTestPlayerWithItems();
        Item potion = player.getInventory().findItemByName("Potion").orElseThrow();

        assertTrue(player.useItem(potion));
        assertEquals(100 + 30, player.getHealth());
        assertFalse(player.getInventory().hasItem(potion));
        assertTrue(outContent.toString().contains("TestPlayer usou Potion."));
    }

    @Test
    void useItem_weaponShouldBeEquippedAndNotRemoved() {
        Player player = createTestPlayerWithItems();
        Item sword = player.getInventory().findItemByName("Sword").orElseThrow();

        assertTrue(player.useItem(sword));
        assertEquals(sword, player.getEquippedWeapon());
        assertTrue(player.getInventory().hasItem(sword));
        assertTrue(outContent.toString().contains("TestPlayer equipou Sword."));
    }

    @Test
    void useItem_shouldFailIfItemNotInInventory() {
        Player player = new Player("TestPlayer", 100, 10, 1);
        Item nonExistentItem = new Item("NonExistent", "Desc", ItemType.MISC, 0);

        assertFalse(player.useItem(nonExistentItem));
        assertEquals(100, player.getHealth());
        assertTrue(outContent.toString().contains("TestPlayer não possui NonExistent."));
    }

    @Test
    void attack_shouldCalculateDamageWithWeapon() {
        Player player = createTestPlayerWithItems();
        Item sword = player.getInventory().findItemByName("Sword").orElseThrow();
        player.equipWeapon(sword);

        int damage = player.attack();
        assertTrue(damage == 25 || damage == 50);
        assertTrue(outContent.toString().contains("TestPlayer ataca com Sword."));
        assertTrue(outContent.toString().contains("TestPlayer causa "));
    }

    @Test
    void attack_shouldCalculateDamageWithoutWeapon() {
        Player player = new Player("TestPlayer", 100, 10, 1); // Sem arma equipada

        int damage = player.attack();
        assertTrue(damage == 10 || damage == 20);
        assertTrue(outContent.toString().contains("TestPlayer ataca sem armas."));
        assertTrue(outContent.toString().contains("TestPlayer causa "));
    }
}