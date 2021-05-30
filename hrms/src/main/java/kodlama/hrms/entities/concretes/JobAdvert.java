package kodlama.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_adverts")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})

public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "jobs_title_id")
	//private int jobsTitleId;
	
	//@Column(name = "employer_id")
	//private int employerId;
	
	//@Column(name = "city_id")
	//private int cityId;
	
	@Column(name = "description")
	private String descripton;
	
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
	
	@Column(name = "open_position_count")
	private int openPositionCount;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "published_at")
	private LocalDate publishedAt;
	
	@Column(name = "created_at",columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate createdAt=LocalDate.now();
	
	@Column(name = "is_open",columnDefinition = "boolean default true")
	private boolean isOpen=true;
	
	@Column(name = "is_active",columnDefinition = "boolean default true")
	private boolean isActive=true;
	
	@Column(name = "is_deleted",columnDefinition = "boolean default false")
	private boolean isDeleted=false;
	
	@ManyToOne
	@JoinColumn(name = "jobs_title_id")
	private JobsTitle jobsTitle;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employers employers;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
}
