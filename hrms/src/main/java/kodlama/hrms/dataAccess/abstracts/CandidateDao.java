package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Candidate;



public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate findByEmail(String email);
	Candidate findByNationalityId(String nationalityId);
	Candidate findById(int id);
}
