package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.City;


public interface CityDao extends JpaRepository<City, Integer>{

}
