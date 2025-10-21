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
        generateRandomNumber(100);

        showInitialMessage();

        setCurrentAttempt(0);

        setGameWon(false);
    }

    public void startGame() {
        while (currentAttempt < maxAttempts && !gameWon) {
            increadAttempt();
            System.out.print("Tentativa " + currentAttempt + "/" + maxAttempts + ". Digite seu palpite: ");

            int guess = readGuess();

            checkGuess(guess);
        }

        checkGameWon();

        playAgain();
    }

    private void checkGameWon() {
        if (!gameWon) {
            System.out.println("Fim de jogo! Você ficou sem tentativas.");
            System.out.println("O número secreto era: " + secretNumber);
        }
    }

    private void playAgain() {
        System.out.println("Deseja jogar novamente? (s/n)");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("s")) {
            initializeGame();
            startGame();
        } else {
            System.out.println("Execução finalizada.");
        }
    }

    private void decreaseAttempt() {
        this.currentAttempt--;
    }

    private void increadAttempt() {
        this.currentAttempt++;
    }

    private void checkGuess(int guess) {
        if (guess == secretNumber) {
            gameWon = true;
            System.out.println("Parabéns! Você adivinhou o número " + secretNumber + " em " + currentAttempt + " tentativas!");
        } else if (guess < secretNumber) {
            System.out.println("Muito baixo! Tente novamente.");
        } else {
            System.out.println("Muito alto! Tente novamente.");
        }
    }

    private int readGuess() {
        int guess = 0;
        try {
            guess = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
            decreaseAttempt();
        }

        return guess;
    }

    private void generateRandomNumber(int numeroMaximo) {
        Random random = new Random();
        secretNumber = random.nextInt(numeroMaximo) + 1; // Número entre 1 e 100
    }

    private void showInitialMessage() {
        System.out.println("O jogo de adivinhar o número começou! Tente adivinhar um número entre 1 e 100.");
        System.out.println("Você tem " + maxAttempts + " tentativas.");
    }

    public int getSecretNumber() { return secretNumber; }
    public int getMaxAttempts() { return maxAttempts; }
    public int getCurrentAttempt() { return currentAttempt; }
    public boolean isGameWon() { return gameWon; }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void setCurrentAttempt(int currentAttempt) {
        this.currentAttempt = currentAttempt;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}