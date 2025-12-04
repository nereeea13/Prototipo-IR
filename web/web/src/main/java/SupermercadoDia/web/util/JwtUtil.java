package SupermercadoDia.web.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // genera clave segura de 256 bits

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(secretKey)
                .compact();
    }
}

