package kodlama.hrms.entities.dtos;

import java.util.List;

import kodlama.hrms.entities.concretes.Candidate;
import kodlama.hrms.entities.concretes.CoverLetter;
import kodlama.hrms.entities.concretes.Image;
import kodlama.hrms.entities.concretes.JobExperience;
import kodlama.hrms.entities.concretes.Language;
import kodlama.hrms.entities.concretes.Link;
import kodlama.hrms.entities.concretes.School;
import kodlama.hrms.entities.concretes.Skill;

public class CandidateCvDto {
	
	public Candidate candidate;
	public List<School> schools;
	public List<Skill> skills;
	public List<Link> links;
	public List<Language> languages;
	public List<JobExperience> jobExperiences;
	public List<CoverLetter> coverLetters;
	public Image image;
}
