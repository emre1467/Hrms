package kodlama.hrms.core.utilities.imageupload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlama.hrms.core.utilities.results.DataResult;

public interface ImageUploaderService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}