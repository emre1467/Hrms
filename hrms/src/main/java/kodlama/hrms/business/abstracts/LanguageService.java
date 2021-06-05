package kodlama.hrms.business.abstracts;


import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import java.util.*;
import kodlama.hrms.entities.concretes.Language;

public interface LanguageService {

	Result add(Language language);
	
	DataResult<List<Language>> getAllByCandidateId(int candidateId);
}