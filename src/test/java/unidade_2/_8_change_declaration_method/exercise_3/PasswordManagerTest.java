package unidade_2._8_change_declaration_method.exercise_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordManagerTest {

    private final PasswordManager manager = new PasswordManager();

    // Testes para validatePassword
    @Test
    void validatePassword_shouldReturnTrueForValidPassword() {
        assertTrue(manager.validatePassword("Senha123!"));
        assertTrue(manager.validatePassword("MyStrongP@ssw0rd"));
    }

    @Test
    void validatePassword_shouldReturnFalseForShortPassword() {
        assertFalse(manager.validatePassword("Short1!"));
    }

    @Test
    void validatePassword_shouldReturnFalseForPasswordWithoutNumber() {
        assertFalse(manager.validatePassword("Senhasegura!"));
    }

    @Test
    void validatePassword_shouldReturnFalseForPasswordWithoutSpecialChar() {
        assertFalse(manager.validatePassword("Senha12345"));
    }

    @Test
    void validatePassword_shouldReturnFalseForNullPassword() {
        assertFalse(manager.validatePassword(null));
    }

    // Testes para encryptPassword
    @Test
    void encryptPassword_shouldAddPrefixAndSuffix() {
        assertEquals("ENC_MyPass_SEC", manager.encryptPassword("MyPass"));
    }

    @Test
    void encryptPassword_shouldHandleEmptyPassword() {
        assertEquals("ENC__SEC", manager.encryptPassword(""));
    }
}
