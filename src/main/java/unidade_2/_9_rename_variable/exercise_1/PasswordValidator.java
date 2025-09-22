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

        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean flag = false;

        for (char c : pwd.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (SPECIAL_CHARS.contains(String.valueOf(c))) {
                flag = true;
            }
        }

        return hasDigit && hasUpper && flag;
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
