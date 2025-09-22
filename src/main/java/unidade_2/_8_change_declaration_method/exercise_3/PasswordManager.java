package unidade_2._8_change_declaration_method.exercise_3;

public class PasswordManager {
    /**
     * Valida se uma senha atende aos requisitos:
     * - Mínimo de 8 caracteres.
     * - Contém um número.
     * - Contém um caractere especial (!@#$%^&*).
     *
     * @param password A senha a ser validada.
     * @return true se a senha for válida, false caso contrário.
     */
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasNumber = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
                break;
            }
        }
        if (!hasNumber) {
            return false;
        }

        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*";
        for (char c : password.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
                break;
            }
        }
        if (!hasSpecialChar) {
            return false;
        }

        return true;
    }

    /**
     * Simula a "criptografia" de uma senha adicionando um prefixo e sufixo fixos.
     * Obs.: estratégia simplificada (difere no mundo real).
     *
     * @param password A senha original.
     * @return A senha "criptografada".
     */
    public String encryptPassword(String password) {
        String prefix = "ENC_";
        String suffix = "_SEC";
        String encrypted = prefix + password + suffix;
        return encrypted;
    }
}
