package kodlama.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Image;

public interface ImageService {

	Result add(Image image,  MultipartFile imageFile);
	DataResult<Image> getByCandidateId(int candidateId);
}
