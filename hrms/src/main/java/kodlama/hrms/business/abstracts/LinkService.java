package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Link;

public interface LinkService {
	DataResult<List<Link>> getall();
	Result add(Link link);
	DataResult<List<Link>> getAllByCandidateId(int candidateId);
}
