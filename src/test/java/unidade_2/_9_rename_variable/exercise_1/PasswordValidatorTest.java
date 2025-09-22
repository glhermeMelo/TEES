package unidade_2._9_rename_variable.exercise_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void checkComplexity_shouldReturnTrueForComplexPassword() {
        assertTrue(validator.checkComplexity("Password123!"));
        assertTrue(validator.checkComplexity("MySecureP@ss2025"));
    }

    @Test
    void checkComplexity_shouldReturnFalseForShortPassword() {
        assertFalse(validator.checkComplexity("Pwd1!"));
    }

    @Test
    void checkComplexity_shouldReturnFalseForPasswordWithoutDigit() {
        assertFalse(validator.checkComplexity("NoNumbers!"));
    }

    @Test
    void checkComplexity_shouldReturnFalseForPasswordWithoutUpperCase() {
        assertFalse(validator.checkComplexity("nouppercase1!"));
    }

    @Test
    void checkComplexity_shouldReturnFalseForPasswordWithoutSpecialChar() {
        assertFalse(validator.checkComplexity("NoSpecialChar1"));
    }

    @Test
    void checkComplexity_shouldReturnFalseForNullPassword() {
        assertFalse(validator.checkComplexity(null));
    }
}
