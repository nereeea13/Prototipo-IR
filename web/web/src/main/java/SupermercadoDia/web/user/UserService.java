package SupermercadoDia.web.user;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean validateUser(String username, String password) {
        Optional<User> user = repo.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    public String getRole(String username) {
        return repo.findByUsername(username)
                   .map(User::getRole)
                   .orElse(null);
    }

    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }
}

