package kodlama.hrms.business.abstracts;

import java.util.*;



import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Skill;

public interface SkillService {

	Result add(Skill skill);
	DataResult<List<Skill>> getAllByCandidateId(int candidateId);
}
