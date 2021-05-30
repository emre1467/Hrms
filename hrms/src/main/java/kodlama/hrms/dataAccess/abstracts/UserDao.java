package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{

}
