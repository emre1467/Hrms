package kodlama.hrms.business.abstracts;

import java.util.List;



import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getall();
	Result add(Language language);
}
