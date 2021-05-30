package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;


import kodlama.hrms.business.abstracts.JobsTitleService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.JobsTitleDao;
import kodlama.hrms.entities.concretes.JobsTitle;

@Service
public class JobsTitleManager implements JobsTitleService{

	private JobsTitleDao jobsTitleDao;
	
	public JobsTitleManager(JobsTitleDao jobsTitleDao) {
		super();
		this.jobsTitleDao = jobsTitleDao;
	}

	@Override
	public DataResult<List<JobsTitle>> getall() {
		return new SuccessDataResult<List<JobsTitle>>(jobsTitleDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(JobsTitle jobsTitle) {
		this.jobsTitleDao.save(jobsTitle);
		return new SuccessResult("ekleme başarılı");
		
	}

}
