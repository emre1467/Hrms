package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Employers;

public interface EmployersService {
	DataResult<List<Employers>> getall();
	Result add(Employers employers);
}
