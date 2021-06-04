package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Skill;

public interface SkillDao  extends JpaRepository<Skill, Integer> {
	List<Skill> findAllByCandidate_Id(int candidateId);
}
