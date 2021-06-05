package kodlama.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.LanguageService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.LanguageDao;
import kodlama.hrms.entities.concretes.Language;

@Service("LanguageManager")
public class LanguageManager implements LanguageService{

	
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}


	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Language added !");
	}


	@Override
	public DataResult<List<Language>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAllByCandidate_Id(candidateId));
	}

}
