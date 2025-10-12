package unidade_2._10_move_function.exercise_3;

public class Item {
    private String name;
    private String description;
    private ItemType type;
    private int value; // Ex: dano para arma, cura para poção

    public Item(String name, String description, ItemType type, int value) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.value = value;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public ItemType getType() { return type; }
    public int getValue() { return value; }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}