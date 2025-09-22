package unidade_2._9_rename_variable.exercise_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private AuthService authService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        authService = new AuthService();
        System.setOut(new PrintStream(outContent));
    }

    // Testes para auth()
    @Test
    void auth_shouldReturnTrueForValidCredentials() {
        assertTrue(authService.auth("admin", "admin_password"));
        assertTrue(outContent.toString().contains("Autenticação bem-sucedida para admin"));
    }

    @Test
    void auth_shouldReturnFalseForInvalidCredentials() {
        assertFalse(authService.auth("admin", "wrong_password"));
        assertTrue(outContent.toString().contains("Falha na autenticação para admin"));
    }

    @Test
    void auth_shouldReturnFalseForNonExistentUser() {
        assertFalse(authService.auth("nonexistent", "any_password"));
        assertTrue(outContent.toString().contains("Falha na autenticação para nonexistent"));
    }

    @Test
    void auth_shouldReturnFalseForNullUsername() {
        assertFalse(authService.auth(null, "any_password"));
    }

    @Test
    void auth_shouldReturnFalseForEmptyPassword() {
        assertFalse(authService.auth("admin", ""));
    }

    // Testes para makeToken()
    @Test
    void makeToken_shouldReturnANonNullTokenForValidUser() {
        String token = authService.makeToken("admin");
        assertNotNull(token);
        assertTrue(token.startsWith("admin:"));
        assertTrue(token.contains(":" + AuthService.SECRET_KEY.hashCode()));
    }

    @Test
    void makeToken_shouldReturnNullForNullUsername() {
        assertNull(authService.makeToken(null));
    }

    @Test
    void makeToken_shouldReturnNullForEmptyUsername() {
        assertNull(authService.makeToken(""));
    }
}
