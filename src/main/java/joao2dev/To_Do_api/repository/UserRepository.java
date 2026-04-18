package joao2dev.To_Do_api.repository;

import joao2dev.To_Do_api.entinty.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String login);
}
