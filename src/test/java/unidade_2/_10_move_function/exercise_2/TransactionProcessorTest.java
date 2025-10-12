package unidade_2._10_move_function.exercise_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorTest {

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

    @Test
    void transferFunds_shouldSucceedWithSufficientFunds() {
        Account alice = new Account("Alice", 100.0);
        Account bob = new Account("Bob", 50.0);
        TransactionProcessor processor = new TransactionProcessor();

        assertTrue(processor.transferFunds(alice, bob, 30.0));
        assertEquals(70.0, alice.getBalance(), 0.001);
        assertEquals(80.0, bob.getBalance(), 0.001);
        assertTrue(outContent.toString().contains("Transferência de R$30,00 realizada com sucesso."));
    }

    @Test
    void transferFunds_shouldFailWithInsufficientFunds() {
        Account alice = new Account("Alice", 100.0);
        Account bob = new Account("Bob", 50.0);
        TransactionProcessor processor = new TransactionProcessor();

        assertFalse(processor.transferFunds(alice, bob, 120.0));
        assertEquals(100.0, alice.getBalance(), 0.001); // Saldo deve permanecer o mesmo
        assertEquals(50.0, bob.getBalance(), 0.001);    // Saldo deve permanecer o mesmo
        assertTrue(outContent.toString().contains("Transferência falhou: Saldo insuficiente na conta de origem."));
    }

    @Test
    void transferFunds_shouldFailWithNegativeAmount() {
        Account alice = new Account("Alice", 100.0);
        Account bob = new Account("Bob", 50.0);
        TransactionProcessor processor = new TransactionProcessor();

        assertFalse(processor.transferFunds(alice, bob, -10.0));
        assertEquals(100.0, alice.getBalance(), 0.001);
        assertEquals(50.0, bob.getBalance(), 0.001);
        assertTrue(outContent.toString().contains("Erro: Valor da transferência deve ser positivo."));
    }

    @Test
    void transferFunds_shouldFailWithZeroAmount() {
        Account alice = new Account("Alice", 100.0);
        Account bob = new Account("Bob", 50.0);
        TransactionProcessor processor = new TransactionProcessor();

        assertFalse(processor.transferFunds(alice, bob, 0.0));
        assertEquals(100.0, alice.getBalance(), 0.001);
        assertEquals(50.0, bob.getBalance(), 0.001);
        assertTrue(outContent.toString().contains("Erro: Valor da transferência deve ser positivo."));
    }
}