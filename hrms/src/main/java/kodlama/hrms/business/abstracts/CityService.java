package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getall();
	Result add(City city);
}
