import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    private final UserRepository userRepository;

    @Autowired
    public PlayerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findPlayerByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void createPlayer(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }
}
