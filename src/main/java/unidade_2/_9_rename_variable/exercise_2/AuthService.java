package unidade_2._9_rename_variable.exercise_2;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class AuthService {

    // Simula um banco de dados de usuários (nome de usuário -> senha hashed)
    private final Map<String, String> userDb = new HashMap<>();

    // Simula uma chave simétrica para geração de token
    static final String SECRET_KEY = "supersecretkey";

    public AuthService() {
        userDb.put("admin", "hashed_admin_password");
        userDb.put("user1", "hashed_user1_password");
    }

    /**
     * Tenta autenticar um usuário com base no nome de usuário e senha fornecidos.
     * Retorna true se a autenticação for bem-sucedida, false caso contrário.
     *
     * @param username O nome de usuário.
     * @param password A senha (ainda não hashed).
     * @return true se as credenciais são válidas, false caso contrário.
     */
    public boolean auth(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false;
        }

        String storedHash = userDb.get(username);

        // Comparação de hash
        boolean correctPassword = (storedHash != null && storedHash.equals("hashed_" + password));

        if (correctPassword) {
            System.out.println("Autenticação bem-sucedida para " + username);
            return true;
        } else {
            System.out.println("Falha na autenticação para " + username);
            return false;
        }
    }

    /**
     * Gera um "token" de sessão após a autenticação.
     *
     * @param uname O nome de usuário para o qual o token será gerado.
     * @return Um token de sessão pseudo-aleatório.
     */
    public String makeToken(String uname) {
        if (uname == null || uname.isEmpty()) {
            return null;
        }
        SecureRandom random = new SecureRandom();

        byte[] bytes = randomBytes(24);

        String token = encodeBase64Password(bytes);

        return uname + ":" + token + ":" + SECRET_KEY.hashCode();
    }

    private byte[] randomBytes(int lenght) {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[lenght];
        random.nextBytes(randomBytes);
        return randomBytes;
    }

    private String encodeBase64Password(byte[] bytesArray) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytesArray);
    }
}
