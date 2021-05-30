package kodlama.hrms.business.abstracts;

import java.util.List;



import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobsTitle;

public interface JobsTitleService {
	DataResult<List<JobsTitle>> getall();
	Result add (JobsTitle jobsTitle);
}
