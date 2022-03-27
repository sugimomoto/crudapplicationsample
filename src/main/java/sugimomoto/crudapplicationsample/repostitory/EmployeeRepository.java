package sugimomoto.crudapplicationsample.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import sugimomoto.crudapplicationsample.model.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
