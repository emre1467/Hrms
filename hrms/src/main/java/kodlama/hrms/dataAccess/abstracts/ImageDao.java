package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

	Image findByCandidate_Id(int candidateId);
	
	Image findById(int id);
}
