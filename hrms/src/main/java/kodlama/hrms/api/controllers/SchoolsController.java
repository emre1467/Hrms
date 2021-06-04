package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.SchoolService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.School;

@RestController	
@RequestMapping("/api/schools")
public class SchoolsController {
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@GetMapping("/getall")
	public DataResult<List<School>> getall(){
		return this.schoolService.getall();
	}
	
	@PostMapping("/add")
	public Result add(School school) {
		return this.schoolService.add(school);				
	}
	
	@GetMapping("/findAllByCandidate_IdOrderByGraduationYear")
	public DataResult<List<School>> findAllByCandidate_IdOrderByGraduationYear(int candidateId){
		return this.schoolService.findAllByCandidate_IdOrderByGraduationYear(candidateId);
	}
}
