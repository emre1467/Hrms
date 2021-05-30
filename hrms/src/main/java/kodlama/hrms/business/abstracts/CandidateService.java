package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getall();
	Result add(Candidate candidate);
}
