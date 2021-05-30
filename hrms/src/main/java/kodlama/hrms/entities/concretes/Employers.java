package kodlama.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper=false)

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employers extends User{
/*
	@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id")
	@Column(name="user_id")
	private int userid;
*/	
	@Column(name="web_site")
	private String webSite;
	
	
	@Column(name="phone_number")
	private String phoneNumber;
	
    @Column(name="is_email_verified")
	private Boolean isEmailVerified;
    
    @Column(name="is_verified_by_emlopyee")
	private Boolean isVerifiedByEmployee;
    
    @Column(name="company_name")
    private String companyName;
    
    @JsonIgnore
    @OneToMany(mappedBy = "employers")
	private List<JobAdvert> jobAdverts;
}
