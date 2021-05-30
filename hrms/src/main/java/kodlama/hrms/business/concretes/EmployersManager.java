package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.EmployersService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.EmployersDao;
import kodlama.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService{

	private EmployersDao employersDao;
	
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}

	@Override
	public DataResult<List<Employers>> getall() {
		return new SuccessDataResult<List<Employers>>(employersDao.findAll(), "employers tablosu getirildi");
	}

	@Override
	public Result add(Employers employers) {
		if(checkIfEmailExists(employers.getEmail())==false) {
			return new ErrorResult("Email already exist");
		}
		if(validationForEmployer(employers)==false) {
			return new ErrorResult("missing information");
		}
		
		employersDao.save(employers);
		return new SuccessResult("employers tablosuna ekleme başarılı");
	}
	
	
	private boolean validationForEmployer(Employers employers) {
		if(employers.getCompanyName()==null||employers.getEmail()==null||employers.getWebSite()==null
				||employers.getPhoneNumber()==null||employers.getPassword()==null) {
			return false;
		}
		return true;
	}
	
	
	private boolean checkIfEmailExists(String email) {
		if(this.employersDao.findByEmail(email) !=null) {
			return false;
		}
		return true;
	}
}
