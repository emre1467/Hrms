package kodlama.hrms.core.utilities.imageupload;


import java.io.IOException;
import java.util.Map;


import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorDataResult;
import kodlama.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploaderManager implements ImageUploaderService {
private Cloudinary cloudinary;
	
	@Autowired
	public ImageUploaderManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "djlycvzmw",
				"api_key", "962499636133871",
				"api_secret", "v6rYjF1d_mUrHLmfUEtzehQaZRw"));
	}
	
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>("cannot added");
	}
}