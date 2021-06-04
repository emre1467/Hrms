package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.SchoolService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.SchoolDao;
import kodlama.hrms.entities.concretes.School;
@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}
	
	@Override
	public DataResult<List<School>> getall() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"school getirildi");
	}
	
	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Ekleme Başarılı"); 
	}

	@Override
	public DataResult<List<School>> findAllByCandidate_IdOrderByGraduationYear(int candidateId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCandidate_IdOrderByGraduationYear(candidateId));
	}
	
}
