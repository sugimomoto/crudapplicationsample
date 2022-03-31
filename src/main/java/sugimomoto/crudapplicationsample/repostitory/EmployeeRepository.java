package sugimomoto.crudapplicationsample.repostitory;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sugimomoto.crudapplicationsample.model.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 
    Collection<Employee> findByNameLike(String name);

    @Query(name = "Employee.searchByNameVariable")
    Collection<Employee> searchByName(String name);
}
