package sugimomoto.crudapplicationsample.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import sugimomoto.crudapplicationsample.model.*;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    
}
