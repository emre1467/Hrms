package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.CityService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.City;

@RestController	
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;
	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getall(){
		return this.cityService.getall();
	}
	
	@PostMapping("/add")
	public Result add(City city) {
		return this.cityService.add(city);
	}
}
