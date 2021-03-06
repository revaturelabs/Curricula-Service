package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "curriculum")
@Entity
public class Curriculum {
	
	@Id
	@Column(name = "curriculum_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int curriculumId;
	
	@Column(name = "curriculum_name")
	private String curriculumName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "curriculum_skill",
			joinColumns = @JoinColumn(name = "curriculum", referencedColumnName = "curriculum_id"),
			inverseJoinColumns = @JoinColumn(name = "skill", referencedColumnName = "skill_id"))
	private List<Skill> skills;

	public Curriculum() {
		super();
	}

	public Curriculum(int curriculumId, String curriculumName, List<Skill> skills) {
		super();
		this.curriculumId = curriculumId;
		this.curriculumName = curriculumName;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Curriculum [curriculumId=" + curriculumId + ", curriculumName=" + curriculumName + ", skills=" + skills
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curriculumId;
		result = prime * result + ((curriculumName == null) ? 0 : curriculumName.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curriculum other = (Curriculum) obj;
		if (curriculumId != other.curriculumId)
			return false;
		if (curriculumName == null) {
			if (other.curriculumName != null)
				return false;
		} else if (!curriculumName.equals(other.curriculumName))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}
  
	public int getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(int curriculumId) {
		this.curriculumId = curriculumId;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}