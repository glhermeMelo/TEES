package unidade_2._10_move_function.exercise_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private List<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            System.out.println("Adicionado: " + item.getName() + " ao inventário.");
            return true;
        }
        System.out.println("Inventário cheio! Não foi possível adicionar " + item.getName());
        return false;
    }

    public boolean removeItem(Item item) {
        if (items.remove(item)) {
            System.out.println("Removido: " + item.getName() + " do inventário.");
            return true;
        }
        return false;
    }

    public Optional<Item> findItemByName(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst();
    }

    public void displayInventory() {
        System.out.println("\n--- Inventário (" + items.size() + "/" + capacity + ") ---");
        if (items.isEmpty()) {
            System.out.println("Vazio.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " [" + items.get(i).getType() + "]");
        }
    }

    public boolean hasItem(Item item) {
        return items.contains(item);
    }
}