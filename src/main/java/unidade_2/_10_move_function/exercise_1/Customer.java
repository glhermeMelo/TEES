package unidade_2._10_move_function.exercise_1;

public class Customer {
    private String name;
    private String customerId;
    private boolean isPremium;

    public Customer(String name, String customerId, boolean isPremium) {
        this.name = name;
        this.customerId = customerId;
        this.isPremium = isPremium;
    }

    public String getName() { return name; }
    public String getCustomerId() { return customerId; }
    public boolean isPremium() { return isPremium; }

}