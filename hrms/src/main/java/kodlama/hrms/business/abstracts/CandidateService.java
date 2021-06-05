package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Candidate;
import kodlama.hrms.entities.dtos.CandidateCvDto;

public interface CandidateService {
	DataResult<List<Candidate>> getall();
	Result add(Candidate candidate);
	DataResult<CandidateCvDto> getDtoById(int candidateId);

	DataResult< Candidate> getById(int candidateId);
	DataResult<Candidate> getByNationalId(String nationalId);

}
