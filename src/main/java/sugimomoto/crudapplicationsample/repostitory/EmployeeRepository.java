package sugimomoto.crudapplicationsample.repostitory;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import sugimomoto.crudapplicationsample.model.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 
    Collection<Employee> findByNameLike(String name);
}
