package unidade_2._12_extract_class.exercise_1;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private int secretNumber;
    private int maxAttempts;
    private int currentAttempt;
    private boolean gameWon;

    private Scanner scanner;

    public GuessingGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.currentAttempt = 0;
        this.gameWon = false;
        this.scanner = new Scanner(System.in);
        initializeGame();
    }

    private void initializeGame() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1; // Número entre 1 e 100
        System.out.println("O jogo de adivinhar o número começou! Tente adivinhar um número entre 1 e 100.");
        System.out.println("Você tem " + maxAttempts + " tentativas.");
        this.currentAttempt = 0;
        this.gameWon = false;
    }

    public void startGame() {
        while (currentAttempt < maxAttempts && !gameWon) {
            currentAttempt++;
            System.out.print("Tentativa " + currentAttempt + "/" + maxAttempts + ". Digite seu palpite: ");

            int guess;
            try {
                guess = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
                currentAttempt--;
                continue;
            }

            if (guess == secretNumber) {
                gameWon = true;
                System.out.println("Parabéns! Você adivinhou o número " + secretNumber + " em " + currentAttempt + " tentativas!");
            } else if (guess < secretNumber) {
                System.out.println("Muito baixo! Tente novamente.");
            } else {
                System.out.println("Muito alto! Tente novamente.");
            }
        }

        if (!gameWon) {
            System.out.println("Fim de jogo! Você ficou sem tentativas.");
            System.out.println("O número secreto era: " + secretNumber);
        }

        System.out.println("Deseja jogar novamente? (s/n)");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("s")) {
            initializeGame();
            startGame();
        } else {
            System.out.println("Execução finalizada.");
        }
    }

    public int getSecretNumber() { return secretNumber; }
    public int getMaxAttempts() { return maxAttempts; }
    public int getCurrentAttempt() { return currentAttempt; }
    public boolean isGameWon() { return gameWon; }
}