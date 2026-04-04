package joao2dev.To_Do_api.repository;

import joao2dev.To_Do_api.entinty.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    String findByUser(String user);
}
