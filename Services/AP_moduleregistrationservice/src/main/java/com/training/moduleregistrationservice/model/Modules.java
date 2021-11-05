package com.training.moduleregistrationservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Modules {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String moduleName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@FutureOrPresent
	private LocalDate startDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@FutureOrPresent
	private LocalDate endDate;
	private int facultyId;
	private String moduleType;

	public Modules() {
		super();
	}

	public Modules(int id, String moduleName, @PastOrPresent LocalDate startDate, @FutureOrPresent LocalDate endDate,
			int facultyId, String moduleType) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.facultyId = facultyId;
		this.moduleType = moduleType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	@Override
	public String toString() {
		return "Modules [id=" + id + ", moduleName=" + moduleName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", facultyId=" + facultyId + ", moduleType=" + moduleType + "]";
	}






	
}
