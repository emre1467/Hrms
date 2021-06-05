package kodlama.hrms.business.abstracts;

import java.util.List;



import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	
	DataResult<List<CoverLetter>> getall();
	Result add(CoverLetter coverLetter);
	DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId);
}
