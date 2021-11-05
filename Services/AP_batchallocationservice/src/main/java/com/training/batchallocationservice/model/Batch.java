package com.training.batchallocationservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.FutureOrPresent;

@Entity
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen", initialValue =21001)
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "port_gen")
	private int id;
	private String batchName;
	@FutureOrPresent
	private LocalDate startDate;
	@FutureOrPresent
	private LocalDate endDate;
	private int maximumStudents;
	private String facultyName;
	private int facultyId;
	/**
	 * 
	 */
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param batchName
	 * @param startDate
	 * @param endDate
	 * @param maximumStudents
	 * @param facultyName
	 * @param facultyId
	 */
	public Batch(int id, String batchName, LocalDate startDate, LocalDate endDate, int maximumStudents,
			String facultyName, int facultyId) {
		super();
		this.id = id;
		this.batchName = batchName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.maximumStudents = maximumStudents;
		this.facultyName = facultyName;
		this.facultyId = facultyId;
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
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}
	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
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
	 * @return the maximumStudents
	 */
	public int getMaximumStudents() {
		return maximumStudents;
	}
	/**
	 * @param maximumStudents the maximumStudents to set
	 */
	public void setMaximumStudents(int maximumStudents) {
		this.maximumStudents = maximumStudents;
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
	@Override
	public String toString() {
		return "Batch [id=" + id + ", batchName=" + batchName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", maximumStudents=" + maximumStudents + ", facultyName=" + facultyName + ", facultyId=" + facultyId
				+ "]";
	}
	
}
