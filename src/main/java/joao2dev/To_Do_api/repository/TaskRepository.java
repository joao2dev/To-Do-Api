package joao2dev.To_Do_api.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Long, Id> {
    String FindByUser(String user);
}
