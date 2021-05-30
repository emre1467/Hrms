package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
