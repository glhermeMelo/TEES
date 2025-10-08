package unidade_2._9_rename_variable.exercise_1;

public class PasswordValidator {

    private static final int MIN_LENGTH = 8;
    private static final String SPECIAL_CHARS = "!@#$%^&*";

    /**
     * Verifica a complexidade de uma senha com base em vários critérios.
     *
     * @param pwd A senha a ser verificada.
     * @return true se a senha atende aos critérios de complexidade, false caso contrário.
     */
    public boolean checkComplexity(String pwd) {
        if (pwd == null || pwd.length() < MIN_LENGTH) {
            return false;
        }

        boolean hasDigit = checkDigit(pwd);
        boolean hasUpper = checkUperCase(pwd);
        boolean hasSPecialChar = checkSpecialChars(pwd);

        return hasDigit && hasUpper && hasSPecialChar;
    }

    private boolean checkSpecialChars(String pwd) {
        boolean hasSpecialChair = false;
        for (char c : pwd.toCharArray()) {
            if (SPECIAL_CHARS.contains(String.valueOf(c))) {
                hasSpecialChair = true;
            }
        }

        return hasSpecialChair;
    }

    private boolean checkDigit (String pwd) {
        boolean hasDigit = false;
        for (char c : pwd.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasDigit;
    }

    private boolean checkUperCase(String pwd) {
        boolean hasUpper = false;
        for (char c : pwd.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
        }

        return hasUpper;
    }

    /**
     * Gera um resumo simples para a senha (não é hash criptográfico).
     *
     * @param password A senha de entrada.
     * @return Um resumo simples.
     */
    public String generateSimpleHash(String password) {
        return "HASH_" + password.hashCode();
    }
}
