package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.CandidateService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Candidate;
import kodlama.hrms.entities.dtos.CandidateCvDto;

@RestController	
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getall(){
		return this.candidateService.getall();
	}
	
	@PostMapping("/add")
	public Result Add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("getCVById")
	public DataResult<CandidateCvDto> getCvById(@RequestParam int candidateId){
		
		return this.candidateService.getDtoById(candidateId);
	}
}
