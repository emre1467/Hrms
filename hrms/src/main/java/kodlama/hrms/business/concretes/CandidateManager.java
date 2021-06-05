package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.CandidateService;
import kodlama.hrms.business.abstracts.CoverLetterService;
import kodlama.hrms.business.abstracts.ImageService;
import kodlama.hrms.business.abstracts.JobExperienceService;
import kodlama.hrms.business.abstracts.LanguageService;
import kodlama.hrms.business.abstracts.LinkService;
import kodlama.hrms.business.abstracts.SchoolService;
import kodlama.hrms.business.abstracts.SkillService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.hrms.entities.concretes.Candidate;
import kodlama.hrms.entities.dtos.CandidateCvDto;

@Service("CandidateManager")
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private JobExperienceService jobExperienceService;
	private ImageService imageService;
	private LanguageService languageService;
	private LinkService linkService;
	private SkillService skillService;
	private SchoolService schoolService;
	private CoverLetterService coverLetterService;
	
	

	public CandidateManager(CandidateDao candidateDao, JobExperienceService jobExperienceService,
			LanguageService languageService, LinkService linkService, SkillService skillService,
			SchoolService schoolService, CoverLetterService coverLetterService,ImageService imageService) {
		super();
		this.candidateDao = candidateDao;
		this.jobExperienceService = jobExperienceService;
		this.languageService = languageService;
		this.linkService = linkService;
		this.skillService = skillService;
		this.schoolService = schoolService;
		this.coverLetterService = coverLetterService;
		this.imageService=imageService;
	}

	@Override
	public DataResult<List<Candidate>> getall() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"candidate tablosu getirildi");
	}

	@Override
	public Result add(Candidate candidate) {
		if(validationForCandidate(candidate)==false) {
			return new ErrorResult("missing information");
		}
		if(checkIfEmailExists(candidate.getEmail())==false) {
			return new ErrorResult("email already exist");
		}
		if(checkIfNationalityPassword(candidate.getNationalityId())==false) {
			return new ErrorResult("nationality already exist");
		}
		
		candidateDao.save(candidate);
		return new SuccessResult("Başarılı");
	}

	private boolean validationForCandidate(Candidate candidate) {
		if(candidate.getFirstName() == null || candidate.getLastName() == null ||
				candidate.getNationalityId() == null
				||/* candidate.getDateOfBirth() == null ||*/ candidate.getEmail() == null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfEmailExists(String email) {
		if(this.candidateDao.findByEmail(email)==null) {
			return true;
		}
		return false;
	}
	private boolean checkIfNationalityPassword(String email) {
		if(this.candidateDao.findByNationalityId(email)==null) {
			return true;
		}
		return false;
		
	}

	@Override
	public DataResult<CandidateCvDto> getDtoById(int candidateId) {
		CandidateCvDto cvDto=new CandidateCvDto();
	
		cvDto.jobExperiences =this.jobExperienceService.getAllByCandidateId(candidateId).getData();
		cvDto.schools = this.schoolService.getAllByCandidateId(candidateId).getData();
		cvDto.languages =this.languageService.getAllByCandidateId(candidateId).getData();
		cvDto.links =this.linkService.getAllByCandidateId(candidateId).getData();
		cvDto.skills =this.skillService.getAllByCandidateId(candidateId).getData();
		cvDto.coverLetters = this.coverLetterService.getAllByCandidateId(candidateId).getData();
		cvDto.image =this.imageService.getByCandidateId(candidateId).getData();
		return new SuccessDataResult<CandidateCvDto>(cvDto);
		
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId));
	}
	

	@Override
	public DataResult<Candidate> getByNationalId(String nationalId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
