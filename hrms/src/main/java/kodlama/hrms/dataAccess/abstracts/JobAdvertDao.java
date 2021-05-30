package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.hrms.entities.concretes.JobAdvert;
import kodlama.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	//@Query("From JobAdvert where isActive =true")
	//List<JobAdvert> getAllOpenJobAdvertList();
	
	//@Query("From JobAdvert where isActive= true and employer_id=:id")
	@Query(value = "SELECT new kodlama.hrms.entities.dtos.JobAdvertDto( ja.employers.companyName as companyName,"+" ja.jobsTitle.name as titleName,"
			+ " ja.openPositionCount as openPositionCount,"+" ja.createdAt as createdDate,"+"ja.deadline as deadline) FROM JobAdvert ja"
			+ " WHERE ja.isActive = true and employer_id=:id")
	List<JobAdvertDto> getAllOpenJobAdvertByEmployers(int id);
	
	@Query(value = "SELECT new kodlama.hrms.entities.dtos.JobAdvertDto( ja.employers.companyName as companyName,"+" ja.jobsTitle.name as titleName,"
			+ " ja.openPositionCount as openPositionCount,"+" ja.createdAt as createdDate,"+"ja.deadline as deadline) FROM JobAdvert ja"
			+ " WHERE ja.isActive = true")
	List<JobAdvertDto> getActiveAdvert();
	
	@Query(value = "SELECT new kodlama.hrms.entities.dtos.JobAdvertDto( ja.employers.companyName as companyName,"+" ja.jobsTitle.name as titleName,"
			+ " ja.openPositionCount as openPositionCount,"+" ja.createdAt as createdDate,"+"ja.deadline as deadline) FROM JobAdvert ja"
			+ " WHERE ja.isActive = true ")
	List<JobAdvertDto> getActiveAdvertByDate(Sort sort);
}
