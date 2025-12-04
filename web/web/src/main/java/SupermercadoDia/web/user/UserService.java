package SupermercadoDia.web.user;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final Map<String, String> userPasswords = Map.of(
            "jefe", "1234",
            "empleado", "1234"
    );

    private final Map<String, String> userRoles = Map.of(
            "jefe", "JEFE",
            "empleado", "EMPLEADO"
    );

    public boolean validateUser(String username, String password) {
        return userPasswords.containsKey(username) &&
               userPasswords.get(username).equals(password);
    }

    public String getRole(String username) {
        return userRoles.get(username);
    }
}
