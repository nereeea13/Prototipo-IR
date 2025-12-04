package SupermercadoDia.web.auth.login;

import SupermercadoDia.web.util.JwtUtil;
import SupermercadoDia.web.user.User;
import SupermercadoDia.web.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
public Map<String, String> login(@RequestBody Map<String, String> body) {
    String username = body.get("username");
    String password = body.get("password");

    User user = userService.findByUsername(username)
                              .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (!user.getPassword().equals(password)) {
        return Map.of("error", "Credenciales incorrectas");
    }

    String token = jwtUtil.generateToken(user.getId().toString()); // Opcional: token puede usar id
    String role = user.getRole();

    return Map.of(
        "token", token,
        "role", role,
        "id", user.getId().toString(),
        "username", user.getUsername()
    );
}

}
