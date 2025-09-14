package unidade_1._3_building_tests;

public class Fibonacci {
    public long calcularTermo(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Termo " + n + " não pode ser menor que zero");

        if (n == 0 || n == 1)
            return 1;

        long[] fib = new long[n];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            if (fib[i - 1] > Long.MAX_VALUE - fib[i - 2]) {
                throw new ArithmeticException("O resultado excede o valor máximo permitido.");
            }

            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n - 1];
    }
}
