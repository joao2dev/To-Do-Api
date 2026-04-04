package joao2dev.To_Do_api.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.concurrent.atomic.LongAccumulator;

public interface UserRepository extends JpaRepository<Long, Id> {
    String FindByEmail(String email);
}
