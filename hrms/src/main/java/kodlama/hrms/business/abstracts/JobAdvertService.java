package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobAdvert;
import kodlama.hrms.entities.dtos.JobAdvertDto;


public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getall();
	Result add(JobAdvert jobAdvert );
	//DataResult<List<JobAdvert>> getAllOpenJobAdvertList();
	DataResult<List<JobAdvertDto>> getAllOpenJobAdvertByEmployers(int id);
	DataResult<List<JobAdvertDto>> getActiveAdvert();
	DataResult<List<JobAdvertDto>> getActiveAdvertByDate(String fieldName, boolean isDesc);
}
