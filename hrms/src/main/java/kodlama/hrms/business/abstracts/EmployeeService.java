package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getall();
	Result add(Employee employee);
}
