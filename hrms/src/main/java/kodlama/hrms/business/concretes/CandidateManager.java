package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.CandidateService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getall() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"candidate tablosu getirildi");
	}

	@Override
	public Result add(Candidate candidate) {
		if(validationForCandidate(candidate)==false) {
			return new ErrorResult("missing information");
		}
		if(checkIfEmailExists(candidate.getEmail())==false) {
			return new ErrorResult("email already exist");
		}
		if(checkIfNationalityPassword(candidate.getNationalityId())==false) {
			return new ErrorResult("nationality already exist");
		}
		
		candidateDao.save(candidate);
		return new SuccessResult("Başarılı");
	}

	private boolean validationForCandidate(Candidate candidate) {
		if(candidate.getFirstName() == null || candidate.getLastName() == null ||
				candidate.getNationalityId() == null
				||/* candidate.getDateOfBirth() == null ||*/ candidate.getEmail() == null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfEmailExists(String email) {
		if(this.candidateDao.findByEmail(email)==null) {
			return true;
		}
		return false;
	}
	private boolean checkIfNationalityPassword(String email) {
		if(this.candidateDao.findByNationalityId(email)==null) {
			return true;
		}
		return false;
		
	}
	
}
