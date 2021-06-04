package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobAdvertService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.CityDao;
import kodlama.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlama.hrms.entities.concretes.JobAdvert;
import kodlama.hrms.entities.dtos.JobAdvertDto;


@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;

	
	public JobAdvertManager(JobAdvertDao jobAdvertDao,CityDao cityDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getall() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(Sort.by("createdAt")),"jobadvert tablosu getirildi");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		
		return new SuccessResult("jobadvert tablosuna eklendi");
	}

	

	@Override
	public DataResult<List<JobAdvertDto>> getAllOpenJobAdvertByEmployers(int id) {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getAllOpenJobAdvertByEmployers(id),"getirildi");
	}

	@Override
	public DataResult<List<JobAdvertDto>> getActiveAdvert() {
		return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getActiveAdvert());
	}

	@Override
	public DataResult<List<JobAdvertDto>> getActiveAdvertByDate(String fieldName, boolean isDesc) {
		var direction = (isDesc)? Sort.Direction.DESC : Sort.Direction.ASC;
		Sort sort = Sort.by(direction,fieldName);
		return new SuccessDataResult<List<JobAdvertDto>>
		(this.jobAdvertDao.getActiveAdvertByDate(sort));
	}

}
