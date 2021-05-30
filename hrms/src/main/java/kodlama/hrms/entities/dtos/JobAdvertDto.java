package kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertDto {
	public String companyName;
	public String titleName;
	public int openPositionCount;
	public LocalDate createdDate;
	public LocalDate deadline;
}
