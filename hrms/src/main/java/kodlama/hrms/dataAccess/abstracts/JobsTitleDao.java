package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.JobsTitle;

public interface JobsTitleDao extends JpaRepository<JobsTitle, Integer>{ 

}
