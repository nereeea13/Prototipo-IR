package SupermercadoDia.web.auth.login;

import SupermercadoDia.web.util.JwtUtil;
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

        String user = body.get("username");
        String pass = body.get("password");

        if (!userService.validateUser(user, pass)) {
            return Map.of("error", "Credenciales incorrectas");
        }

        String role = userService.getRole(user);
        String token = jwtUtil.generateToken(user);

        return Map.of(
                "token", token,
                "role", role
        );
    }
}
