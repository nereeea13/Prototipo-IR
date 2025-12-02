package SupermercadoDia.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors()  // Habilita CORS
            .and()
            .csrf().disable()  // Deshabilita CSRF para desarrollo
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/hola").permitAll() // Permite este endpoint sin autenticación
                .anyRequest().authenticated()
            );

        return http.build();
    }
}

