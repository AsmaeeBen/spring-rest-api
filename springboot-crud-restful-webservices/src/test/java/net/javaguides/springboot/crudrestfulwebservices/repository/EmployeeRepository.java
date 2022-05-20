package net.javaguides.springboot.crudrestfulwebservices.repository;

import net.javaguides.springboot.crudrestfulwebservices.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
