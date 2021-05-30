package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.JobsTitleService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobsTitle;

@RestController	
@RequestMapping("/api/jobstitle")
public class JobsTitleController {
	
	private JobsTitleService jobsTitleService;

	@Autowired
	public JobsTitleController(JobsTitleService jobsTitleService) {
		super();
		this.jobsTitleService = jobsTitleService;
	}
	@GetMapping("/getall")
	public DataResult<List<JobsTitle>> getall() {
		return this.jobsTitleService.getall();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobsTitle jobsTitle) {
		return this.jobsTitleService.add(jobsTitle);
	}
}
