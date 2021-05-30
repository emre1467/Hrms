package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.JobAdvertService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobAdvert;
import kodlama.hrms.entities.dtos.JobAdvertDto;


@RestController	
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getall(){
		return this.jobAdvertService.getall();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvertDto>> getAllOpenJobAdvertByEmployers(int id){
		return this.jobAdvertService.getAllOpenJobAdvertByEmployers(id);
	}
	
	@GetMapping("/getActiveAdvert")
	public DataResult<List<JobAdvertDto>> getActiveAdvert(){
		return this.jobAdvertService.getActiveAdvert();
	}
	@GetMapping("/getActiveAdvertisementsSortByCreatedDate")
	public DataResult<List<JobAdvertDto>> getActiveAdvertisementsSortByCreatedDate(boolean isDesc) {
		return this.jobAdvertService.getActiveAdvertByDate("createdDate", isDesc);
	}
}
