package com.training.moduleregistrationservice.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Modules {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String moduleName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;
	private int facultyId;
	private String facultyName;
	private String moduleType;

	public Modules() {
		super();
	}

	/**
	 * @param id
	 * @param moduleName
	 * @param startDate
	 * @param endDate
	 * @param facultyId
	 * @param facultyName
	 * @param moduleType
	 */
	public Modules(int id, String moduleName, LocalDate startDate, LocalDate endDate, int facultyId, String facultyName,
			String moduleType) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.moduleType = moduleType;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the facultyId
	 */
	public int getFacultyId() {
		return facultyId;
	}

	/**
	 * @param facultyId the facultyId to set
	 */
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	/**
	 * @return the facultyName
	 */
	public String getFacultyName() {
		return facultyName;
	}

	/**
	 * @param facultyName the facultyName to set
	 */
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	/**
	 * @return the moduleType
	 */
	public String getModuleType() {
		return moduleType;
	}

	/**
	 * @param moduleType the moduleType to set
	 */
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	@Override
	public String toString() {
		return "Modules [id=" + id + ", moduleName=" + moduleName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", facultyId=" + facultyId + ", facultyName=" + facultyName + ", moduleType=" + moduleType + "]";
	}

	




	
}
