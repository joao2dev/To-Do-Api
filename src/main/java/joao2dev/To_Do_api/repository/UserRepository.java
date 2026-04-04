package joao2dev.To_Do_api.repository;

import joao2dev.To_Do_api.entinty.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    String findByEmail(String email);
}
