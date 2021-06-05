package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobExperienceService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.hrms.entities.concretes.JobExperience;


@Service
public class JobExperienceManager implements JobExperienceService{

	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	private JobExperienceDao jobExperienceDao;
	
	@Override
	public DataResult<List<JobExperience>> getall() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"JobExperience getirildi");
	}

	@Override
	public Result add(JobExperience experience) {
		this.jobExperienceDao.save(experience);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public DataResult<List<JobExperience>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCandidate_Id(candidateId));
	}

}
