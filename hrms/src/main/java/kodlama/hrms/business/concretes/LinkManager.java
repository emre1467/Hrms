package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.LinkService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.LinkDao;
import kodlama.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public DataResult<List<Link>> getall() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("başarılı");
	}

	@Override
	public DataResult<List<Link>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAllByCandidate_Id(candidateId));
	}

}
