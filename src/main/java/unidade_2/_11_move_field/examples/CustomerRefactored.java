package unidade_2._11_move_field.examples;

import java.time.LocalDate;

public class CustomerRefactored {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;

    // Após Move Field, novo campo é uma referência ao objeto ContactInfo
    private ContactInfo contactInfo;

    public CustomerRefactored(String id, String firstName, String lastName,
                              ContactInfo contactInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = LocalDate.now();
        this.contactInfo = contactInfo;
    }

    // Getters para as propriedades centrais do Cliente
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getRegistrationDate() { return registrationDate; }

    // Getter para o objeto ContactInfo
    public ContactInfo getContactInfo() { return contactInfo; }

    // Os getters e setters para email e phoneNumber foram movidos para ContactInfo
    // Acessíveis via getContactInfo().getEmail(), etc.

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void displayCustomerInfo() {
        System.out.println("\n--- Customer Info ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + getFullName());
        System.out.println("Registered: " + registrationDate);
        System.out.println(contactInfo.toString());
    }
}