package kodlama.hrms.business.abstracts;

import java.util.List;



import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getall();
	Result add(School school);
	DataResult<List<School>>  getAllByCandidate_IdOrderByGraduationYear(int candidateId);
	DataResult<List<School>> getAllByCandidateId(int candidateId);
}
