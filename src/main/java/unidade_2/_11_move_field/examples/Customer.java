package unidade_2._11_move_field.examples;

import java.time.LocalDate;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;
    private String email;
    private String phoneNumber;

    public Customer(String id, String firstName, String lastName,
                    String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = LocalDate.now();
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters para as propriedades centrais do Cliente
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getRegistrationDate() { return registrationDate; }

    // Getters para as propriedades de contato
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    // Setters para as propriedades de contato
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void displayCustomerInfo() {
        System.out.println("\n--- Customer Info ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + getFullName());
        System.out.println("Registered: " + registrationDate);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }
}