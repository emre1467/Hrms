package kodlama.hrms.business.abstracts;

import java.util.List;



import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getall();
	Result add(Skill skill);
}
