package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.SkillService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.SkillDao;
import kodlama.hrms.entities.concretes.Skill;
@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;
	
	@Override
	public DataResult<List<Skill>> getall() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(),"getirildi");
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("eklendi");
	}

}
