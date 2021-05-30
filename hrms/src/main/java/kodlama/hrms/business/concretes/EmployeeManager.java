package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.EmployeeService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getall() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(),"Employee tablosu getirildi");
	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessResult("employees tablosuna ekleme başarılı");
	}
}
