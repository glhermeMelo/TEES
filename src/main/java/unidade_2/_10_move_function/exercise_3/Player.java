package unidade_2._10_move_function.exercise_3;

public class Player {
    private String name;
    private int health;
    private int attackPower;
    private Inventory inventory;
    private Item equippedWeapon;

    public Player(String name, int health, int attackPower, int inventoryCapacity) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.inventory = new Inventory(inventoryCapacity);
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }
    public Inventory getInventory() { return inventory; }
    public Item getEquippedWeapon() { return equippedWeapon; }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(name + " takes " + damage + " damage. Health: " + health);
    }

    public void heal(int amount) {
        this.health += amount;
        System.out.println(name + " healed for " + amount + ". Health: " + health);
    }

    public void equipWeapon(Item weapon) {
        if (weapon != null && weapon.getType() == ItemType.WEAPON && inventory.hasItem(weapon)) {
            this.equippedWeapon = weapon;
            System.out.println(name + " equipou: " + weapon.getName());
        } else {
            System.out.println("Não foi possível equipar " + (weapon != null ? weapon.getName() : "nada") + ".");
        }
    }

    /**
     * Lógica de uso de item.
     *
     * @param item O item a ser usado.
     *
     * @return true se o item foi usado com sucesso, false caso contrário.
     */
    public boolean useItem(Item item) {
        if (!inventory.hasItem(item)) {
            System.out.println(name + " não possui " + item.getName() + ".");
            return false;
        }

        if (item.getType() == ItemType.POTION) {
            heal(item.getValue()); // Aplica o efeito da poção
            inventory.removeItem(item); // Remove do inventário
            System.out.println(name + " usou " + item.getName() + ".");
            return true;
        } else if (item.getType() == ItemType.WEAPON) {
            // Se for uma arma, tenta equipar
            equipWeapon(item);
            System.out.println(name + " equipou " + item.getName() + ".");
            // Não remove arma do inventário ao equipar
            return true;
        } else {
            System.out.println(name + " não sabe como usar " + item.getName() + ".");
            return false;
        }
    }

    /**
     * Calcula o dano base e aplica um multiplicador crítico.
     *
     * @return O valor total do dano.
     */
    public int attack() {
        int baseDamage = this.attackPower;
        if (equippedWeapon != null && equippedWeapon.getType() == ItemType.WEAPON) {
            baseDamage += equippedWeapon.getValue(); // Adiciona dano da arma
            System.out.println(name + " ataca com " + equippedWeapon.getName() + ".");
        } else {
            System.out.println(name + " ataca sem armas.");
        }

        // Simula um acerto crítico (25% de chance)
        if (Math.random() < 0.25) {
            baseDamage *= 2; // Dano dobrado
            System.out.println("ACERTO CRÍTICO!");
        }

        System.out.println(name + " causa " + baseDamage + " de dano.");
        return baseDamage;
    }
}